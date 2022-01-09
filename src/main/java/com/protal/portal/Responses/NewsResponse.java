package com.protal.portal.Responses;

import com.protal.portal.Model.News;

import java.util.List;

public class NewsResponse {
    private Integer statusCode;
    private String status;
    private List<News> secondaryNews;
    private List<News> mainNews;

    public List<News> getMainNews() {
        return mainNews;
    }

    public void setMainNews(List<News> mainNews) {
        this.mainNews = mainNews;
    }

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

    public List<News> getSecondaryNews() {
        return secondaryNews;
    }

    public void setSecondaryNews(List<News> secondaryNews) {
        this.secondaryNews = secondaryNews;
    }
}
