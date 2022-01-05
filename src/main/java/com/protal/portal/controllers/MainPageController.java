package com.protal.portal.controllers;

import com.protal.portal.Model.News;
import com.protal.portal.Responses.NewsResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/portal")
@CrossOrigin
public class MainPageController {

    private final RestTemplate restTemplate;

    public MainPageController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();

    }

    @GetMapping("/news")
    public NewsResponse getNews() throws IOException {
        NewsResponse newsResponse = new NewsResponse();
        URL url = new URL("https://www.formula1.com/");
        Document doc = Jsoup.parse(url, 3*1000);

        String text = doc.body().text();
        List<News> newsList= new ArrayList<>();
        Elements link = doc.select("div.col-6 > a");
        for(Element element : link){
            News news = new News();
            news.setArticle(element.getElementsByClass("f1--s").text());
            news.setArticleUrl("https://www.formula1.com/" + element.attr("href"));
            news.setArticleImage(element.getElementsByTag("img").attr("data-src"));
            newsList.add(news);

            System.out.println(element.getElementsByTag("img").attr("data-src"));
            System.out.println(element.getElementsByClass("f1--s").text());

            String Test = element.attr("href");
            System.out.println(Test); // outputs 1

        }

        newsResponse.setNews(newsList);
        newsResponse.setStatusCode(200);
        newsResponse.setStatus("SUCCESS");
        //System.out.println(text); // outputs 1
        return newsResponse
                ;
    }

}
