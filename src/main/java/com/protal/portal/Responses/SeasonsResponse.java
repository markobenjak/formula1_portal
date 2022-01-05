package com.protal.portal.Responses;

import com.protal.portal.Model.Constructor;
import com.protal.portal.Model.Season;

import java.util.List;

public class SeasonsResponse {
    private Integer statusCode;
    private String status;
    private List<Season> seasons;

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

    public List<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }
}
