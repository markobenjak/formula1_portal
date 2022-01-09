package com.protal.portal.Responses;

import com.protal.portal.Model.Constructor;
import com.protal.portal.Model.CurrentSeason;
import com.protal.portal.Model.Race;

import java.util.List;

public class CurrentSeasonsResponse {
    private Integer statusCode;
    private String status;
    private List<Race> currentSeason;

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

    public List<Race> getCurrentSeason() {
        return currentSeason;
    }

    public void setCurrentSeason(List<Race> currentSeason) {
        this.currentSeason = currentSeason;
    }
}
