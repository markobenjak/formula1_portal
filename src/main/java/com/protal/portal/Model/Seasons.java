package com.protal.portal.Model;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlType(name = "MRData", propOrder = {"seasons"})
@XmlRootElement(name = "MRData")
@XmlAccessorType(XmlAccessType.NONE)
public class Seasons {

    @XmlElementWrapper(name = "StandingsTable")
    @XmlElement(name = "StandingsList")
    private List<Season> seasons = null;


    public List<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }
}
