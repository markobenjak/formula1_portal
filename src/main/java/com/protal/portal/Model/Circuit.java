package com.protal.portal.Model;

import javax.xml.bind.annotation.*;

@XmlType(propOrder = {"name", "circuitLocation"})
@XmlRootElement(name = "Circuit")
@XmlAccessorType(XmlAccessType.NONE)
public class Circuit {

    @XmlElement(name = "CircuitName")
    private String name;
    @XmlElement(name = "Location")
    private CircuitLocation circuitLocation;

    @XmlAttribute(name = "url")
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CircuitLocation getCircuitLocation() {
        return circuitLocation;
    }

    public void setCircuitLocation(CircuitLocation circuitLocation) {
        this.circuitLocation = circuitLocation;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
