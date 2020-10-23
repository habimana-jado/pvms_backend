package com.kist.pvms.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.UUID;

/**
 * Created by nizey on 8/14/2020.
 */
@Entity
@Data
public class Account implements Serializable {
    @Id
    private String accountId = UUID.randomUUID().toString();
    private String username;
    private String password;
    private String access;
    private String status;

    @OneToOne
    private Admin admin;

    @OneToOne
    private SecurityGuard securityGuard;



}
