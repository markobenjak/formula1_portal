package com.protal.portal.Model;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlType(name = "MRData", propOrder = {"circuits"})
@XmlRootElement(name = "MRData")
@XmlAccessorType(XmlAccessType.NONE)
public class Circuits {

    @XmlAttribute
    private Integer total;


    @XmlElementWrapper(name = "CircuitTable")
    @XmlElement(name = "Circuit")
    private List<Circuit> circuits = null;

    public List<Circuit> getCircuits() {
        return circuits;
    }

    public void setCircuits(List<Circuit> circuits) {
        this.circuits = circuits;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
