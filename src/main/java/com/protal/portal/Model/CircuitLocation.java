package com.protal.portal.Model;

import javax.xml.bind.annotation.*;

@XmlType(propOrder = {"locality", "country"})
@XmlRootElement(name = "Location")
@XmlAccessorType(XmlAccessType.NONE)
public class CircuitLocation {

    @XmlElement(name = "Locality")
    private String locality;
    @XmlElement(name = "Country")
    private String country;

    @XmlAttribute(name = "lat")
    private String latitude;
    @XmlAttribute(name = "long")
    private String longitude;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
