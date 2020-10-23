package com.kist.pvms.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

/**
 * Created by nizey on 8/14/2020.
 */
@Entity
@Data
public class Visitor extends Person implements Serializable {

    @JsonIgnore
    @OneToMany(mappedBy = "visitor", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    private List<VisitorVisitingPlan> visitorVisitingPlan;


}
