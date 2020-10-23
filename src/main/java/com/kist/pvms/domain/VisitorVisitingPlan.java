package com.kist.pvms.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * Created by nizey on 8/14/2020.
 */
@Entity
@Data
public class VisitorVisitingPlan implements Serializable{
    @Id
    private String visitingPlanId = UUID.randomUUID().toString();
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date visitDate;
    @Enumerated(EnumType.STRING)
    private ERelationship relationship;
    @Temporal(TemporalType.TIMESTAMP)
    private Date visitTime;
    private String visitReferenceNo = new Date().toString().concat(UUID.randomUUID().toString().substring(1,6));
    @Enumerated(EnumType.STRING)
    private EVisitStatus visitStatus;

    @ManyToOne
    private Visitor visitor;

    @ManyToOne
    private PrisonVisitingPlan prisonVisitingPlan;

    @ManyToOne
    private Prisoner prisoner;
}
