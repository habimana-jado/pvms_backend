package com.kist.pvms.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by nizey on 8/14/2020.
 */
@Entity
@Data
public class Admin implements Serializable {
    @Id
    private String nationalId;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    private String phone;
    private String email;
    @Enumerated(EnumType.STRING)
    private EGender gender;

    @ManyToOne
    private Prison prison;

    @JsonIgnore
    @OneToOne(mappedBy = "admin", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Account user;
}
