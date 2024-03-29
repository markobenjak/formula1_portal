package com.protal.portal.controllers;

import com.protal.portal.Model.CurrentSeason;
import com.protal.portal.Model.News;
import com.protal.portal.Responses.SocialMediaResponse;
import com.protal.portal.Responses.CurrentSeasonsResponse;
import com.protal.portal.Responses.NewsResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import twitter4j.*;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/portal")
@CrossOrigin
public class MainPageController {

    private final RestTemplate restTemplate;

    public MainPageController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();

    }

    @GetMapping("/currentSeason")
    public CurrentSeasonsResponse currentSeason() throws JAXBException {
        CurrentSeasonsResponse currentSeasonResponse = new CurrentSeasonsResponse();
        String url = "http://ergast.com/api/f1/2022";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));

        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                request,
                String.class,
                1
        );
        if (response.getStatusCode() == HttpStatus.OK) {
            JAXBContext jaxbContext = JAXBContext.newInstance(CurrentSeason.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            CurrentSeason generatedCurrentSeason = (CurrentSeason) unmarshaller.unmarshal(new StringReader(response.getBody().toString()));
            currentSeasonResponse.setStatusCode(response.getStatusCodeValue());
            currentSeasonResponse.setStatus("SUCCESS");
            currentSeasonResponse.setCurrentSeason(generatedCurrentSeason.getRace());
        } else {
            currentSeasonResponse.setStatusCode(response.getStatusCodeValue());
            currentSeasonResponse.setStatus("Fail");
            currentSeasonResponse.setCurrentSeason(null);
        }

        return currentSeasonResponse;
    }

    @GetMapping("/news")
    public NewsResponse getNews() throws IOException {
        NewsResponse newsResponse = new NewsResponse();
        URL url = new URL("https://www.formula1.com/");
        Document doc = Jsoup.parse(url, 3*1000);

        String text = doc.body().text();
        List<News> mainNewsList= new ArrayList<>();
        List<News> secondaryNewsList= new ArrayList<>();
        Elements secondaryNews = doc.select("div.col-6 > a");
        for(Element secondary : secondaryNews){
            News news = new News();
            news.setArticle(secondary.getElementsByClass("f1--s").text());
            news.setArticleUrl("https://www.formula1.com/" + secondary.attr("href"));
            news.setArticleImage(secondary.getElementsByTag("img").attr("data-src"));
            secondaryNewsList.add(news);
        }

        Elements mainNews = doc.select("fieldset.f1-border--top-right > a");
        for(Element main : mainNews){
            News news = new News();
            news.setArticle(main.getElementsByClass("f1--title").text());
            news.setArticleUrl("https://www.formula1.com/" + main.attr("href"));
            news.setArticleImage(main.getElementsByTag("img").attr("data-src"));
            mainNewsList.add(news);
        }

        newsResponse.setSecondaryNews(secondaryNewsList);
        newsResponse.setMainNews(mainNewsList);
        newsResponse.setStatusCode(200);
        newsResponse.setStatus("SUCCESS");
        return newsResponse;
    }

    @GetMapping("/socialMedia")
    public ResponseEntity<?> getSocialMedia(@RequestParam("hashtag") String hashtag) throws TwitterException {
        List<String> urlList = new ArrayList<>();
        Twitter twitter = TwitterFactory.getSingleton();
        Query query = new Query("#" + hashtag);
        query.count(10);
        QueryResult result = twitter.search(query);
        for (Status status : result.getTweets()) {
            String url= "https://twitframe.com/show?url=https://twitter.com/" + status.getUser().getScreenName()
                    + "/status/" + status.getId();
            urlList.add(url);
        }

        return ResponseEntity.ok(new SocialMediaResponse(
                urlList));
    }


}
