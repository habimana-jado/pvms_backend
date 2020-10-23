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
public class SecurityGuard extends Person implements Serializable {

    @ManyToOne
    private Prison prison;

    @JsonIgnore
    @OneToOne(mappedBy = "securityGuard", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Account account;
}
