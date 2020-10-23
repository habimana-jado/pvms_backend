package com.kist.pvms.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

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
public class CrimeCase implements Serializable{
    @Id
    private String caseId = UUID.randomUUID().toString();
    private String crimeCommitted;
    @Temporal(TemporalType.DATE)
    private Date caseRegistration;
    @Temporal(TemporalType.DATE)
    private Date prisonerDateIn;
    @Temporal(TemporalType.DATE)
    private Date prisonerDateOut;

    @ManyToOne
    private Prisoner prisoner;

    @ManyToOne
    private Prison prison;

}
