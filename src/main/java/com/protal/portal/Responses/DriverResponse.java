package com.protal.portal.Responses;

import com.protal.portal.Model.Driver;
import com.protal.portal.Model.Drivers;

import java.util.List;

public class DriverResponse {
    private Integer statusCode;
    private String status;
    private List<Driver> drivers;

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

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }
}
