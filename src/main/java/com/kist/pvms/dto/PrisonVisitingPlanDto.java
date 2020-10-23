package com.kist.pvms.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.UUID;

/**
 * Created by nizey on 8/15/2020.
 */
@Data
public class PrisonVisitingPlanDto {

    private int visitWeek;
    private int totalPeopleVisitingInOneHour;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "HH:MM")
    private Date startingHour;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "HH:MM")
    private Date endingHour;

    private String prisonId;
}
