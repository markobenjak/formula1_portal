package com.protal.portal.Responses;

import com.protal.portal.Model.Circuit;
import com.protal.portal.Model.Circuits;
import com.protal.portal.Model.Constructor;

import java.util.List;

public class CircuitsResponse {
    private Integer statusCode;
    private String status;
    private Integer totalCircuits;
    private List<Circuit> circuits;

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

    public List<Circuit> getCircuits() {
        return circuits;
    }

    public void setCircuits(List<Circuit> circuits) {
        this.circuits = circuits;
    }

    public Integer getTotalCircuits() {
        return totalCircuits;
    }

    public void setTotalCircuits(Integer totalCircuits) {
        this.totalCircuits = totalCircuits;
    }
}
