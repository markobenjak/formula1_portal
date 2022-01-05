package com.protal.portal.Model;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlType(propOrder = {"driverStanding"})
@XmlRootElement(name = "DriverStanding")
@XmlAccessorType(XmlAccessType.NONE)
public class Season {

    @XmlElement(name = "DriverStanding")
    private List<DriverStanding> driverStanding;

    public List<DriverStanding> getDriverStanding() {
        return driverStanding;
    }

    public void setDriverStanding(List<DriverStanding> driverStanding) {
        this.driverStanding = driverStanding;
    }
}
