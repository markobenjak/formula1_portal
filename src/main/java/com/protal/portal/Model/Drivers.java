package com.protal.portal.Model;

import javax.xml.bind.annotation.*;
import java.util.List;
@XmlType(name = "MRData", propOrder = {"drivers"})
@XmlRootElement(name = "MRData")
@XmlAccessorType(XmlAccessType.NONE)
public class Drivers {

    @XmlAttribute
    private Integer total;

    @XmlElementWrapper(name = "DriverTable")
    @XmlElement(name = "Driver")
    private List<Driver> drivers = null;

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
