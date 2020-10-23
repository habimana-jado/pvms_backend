package com.kist.pvms.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by nizey on 8/14/2020.
 */
@Entity
@Data
public class PrisonVisitingPlan implements Serializable{
    @Id
    private String prisonVisitingPlanId = UUID.randomUUID().toString();
    private int visitWeek;
    private int totalPeopleVisitingInOneHour;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "HH:MM")
    private Date startingHour;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "HH:MM")
    private Date endingHour;

    @ManyToOne
    private Prison prison;

    @JsonIgnore
    @OneToMany(mappedBy = "prisonVisitingPlan", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    private List<VisitorVisitingPlan> visitorVisitingPlan;
}
