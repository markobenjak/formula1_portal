package com.protal.portal.Model;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlType(name = "MRData", propOrder = {"constructors"})
@XmlRootElement(name = "MRData")
@XmlAccessorType(XmlAccessType.NONE)
public class Constructors {

    @XmlElementWrapper(name = "ConstructorTable")
    @XmlElement(name = "Constructor")
    private List<Constructor> constructors = null;

    public List<Constructor> getConstructors() {
        return constructors;
    }

    public void setConstructors(List<Constructor> constructors) {
        this.constructors = constructors;
    }
}
