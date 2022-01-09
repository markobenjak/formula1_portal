package com.protal.portal.Model;

import javax.xml.bind.annotation.*;

@XmlType(propOrder = {"raceName", "circuit", "date", "time"})
@XmlRootElement(name = "Constructor")
@XmlAccessorType(XmlAccessType.NONE)
public class Race {

    @XmlElement(name = "RaceName")
    private String raceName;
    @XmlElement(name = "Circuit")
    private Circuit circuit;
    @XmlElement(name = "Date")
    private String date;
    @XmlElement(name = "Time")
    private String time;

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public Circuit getCircuit() {
        return circuit;
    }

    public void setCircuit(Circuit circuit) {
        this.circuit = circuit;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
