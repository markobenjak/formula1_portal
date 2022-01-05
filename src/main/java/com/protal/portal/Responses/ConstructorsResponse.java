package com.protal.portal.Responses;

import com.protal.portal.Model.Constructor;

import java.util.List;

public class ConstructorsResponse {
    private Integer statusCode;
    private String status;
    private List<Constructor> constructors;

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

    public List<Constructor> getConstructors() {
        return constructors;
    }

    public void setConstructors(List<Constructor> constructors) {
        this.constructors = constructors;
    }
}
