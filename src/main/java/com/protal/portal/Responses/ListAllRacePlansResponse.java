package com.protal.portal.Responses;

import com.protal.portal.Model.RacePlan;

import java.util.List;

public class ListAllRacePlansResponse {
    private List<RacePlan> racePlans;

    public ListAllRacePlansResponse(List<RacePlan> racePlans) {
        this.racePlans = racePlans;
    }

    public List<RacePlan> getRacePlans() {
        return racePlans;
    }

    public void setRacePlans(List<RacePlan> racePlans) {
        this.racePlans = racePlans;
    }
}
