package com.protal.portal.Model;

import javax.xml.bind.annotation.*;

@XmlType(propOrder = {"givenName", "familyName", "dateOfBirth", "nationality"})
@XmlRootElement(name = "Driver")
@XmlAccessorType(XmlAccessType.NONE)
public class Driver {

    @XmlElement(name = "GivenName")
    private String givenName;

    @XmlElement(name = "FamilyName")
    private String familyName;

    @XmlElement(name = "DateOfBirth")
    private String dateOfBirth;

    @XmlElement(name = "Nationality")
    private String nationality;

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
