package com.kist.pvms.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * Created by nizey on 8/14/2020.
 */
@Entity
@Data
public class Prison implements Serializable{
    @Id
    private String prisonId = UUID.randomUUID().toString();
    private String prisonName;
    private String visitingHours;
    private String email;
    private String phoneNumber;

    @ManyToOne
    private Location location;

    @JsonIgnore
    @OneToMany(mappedBy = "prison", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    private List<CrimeCase> crimeCase;

    @JsonIgnore
    @OneToMany(mappedBy = "prison", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    private List<Admin> admin;

    @JsonIgnore
    @OneToMany(mappedBy = "prison", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    private List<SecurityGuard> securityGuard;

    @JsonIgnore
    @OneToMany(mappedBy = "prison", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    private List<PrisonVisitingPlan> prisonVisitingPlan;
}
