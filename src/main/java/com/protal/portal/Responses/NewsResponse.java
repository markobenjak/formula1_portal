package com.protal.portal.Responses;

import com.protal.portal.Model.News;
import com.protal.portal.Model.Season;

import java.util.List;

public class NewsResponse {
    private Integer statusCode;
    private String status;
    private List<News> news;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }
}
