package com.protal.portal.Model;

import javax.xml.bind.annotation.*;

@XmlType(propOrder = {"name", "nationality"})
@XmlRootElement(name = "Constructor")
@XmlAccessorType(XmlAccessType.NONE)
public class Constructor {

    @XmlElement(name = "Name")
    private String name;
    @XmlElement(name = "Nationality")
    private String nationality;
    @XmlAttribute(name = "url")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
