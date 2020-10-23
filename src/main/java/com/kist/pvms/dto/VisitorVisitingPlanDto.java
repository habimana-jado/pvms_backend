package com.kist.pvms.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kist.pvms.domain.*;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * Created by nizey on 8/15/2020.
 */
@Data
public class VisitorVisitingPlanDto {

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date visitDate;
    @Enumerated(EnumType.STRING)
    private ERelationship relationship;
    @Temporal(TemporalType.TIMESTAMP)
    private Date visitTime;

    private String visitorId;

    private String prisonVisitingPlanId;

    private String prisonerId;
}
