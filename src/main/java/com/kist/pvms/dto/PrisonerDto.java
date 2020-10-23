package com.kist.pvms.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kist.pvms.domain.EGender;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * Created by nizey on 8/14/2020.
 */
@Data
public class PrisonerDto implements Serializable {

    private String crimeCommitted;
    @Temporal(TemporalType.DATE)
    private Date caseRegistration = new Date();
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date prisonerDateIn;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date prisonerDateOut;

    private String nationalId;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    private String phone;
    private String email;
    @Enumerated(EnumType.STRING)
    private EGender gender;

    private String prisonId;
}
