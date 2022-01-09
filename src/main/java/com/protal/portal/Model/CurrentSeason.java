package com.protal.portal.Model;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlType(name = "MRData", propOrder = {"race"})
@XmlRootElement(name = "MRData")
@XmlAccessorType(XmlAccessType.NONE)
public class CurrentSeason {

    @XmlElementWrapper(name = "RaceTable")
    @XmlElement(name = "Race")
    private List<Race> race = null;

    public List<Race> getRace() {
        return race;
    }

    public void setRace(List<Race> race) {
        this.race = race;
    }
}
