package com.protal.portal.Model;

import javax.xml.bind.annotation.*;

@XmlType(propOrder = {"constructor", "driver"})
@XmlRootElement(name = "DriverStanding")
@XmlAccessorType(XmlAccessType.NONE)
public class DriverStanding {

    @XmlElement(name = "Constructor")
    private Constructor constructor;

    @XmlElement(name = "Driver")
    private Driver driver;

    @XmlAttribute(name = "position")
    private String position;

    @XmlAttribute(name = "points")
    private String points;

    @XmlAttribute(name = "wins")
    private String wins;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }

    public Constructor getConstructor() {
        return constructor;
    }

    public void setConstructor(Constructor constructor) {
        this.constructor = constructor;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
