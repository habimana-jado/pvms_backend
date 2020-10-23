package com.kist.pvms.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by nizey on 8/14/2020.
 */
@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Person implements Serializable {
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
    private String personType;


}
