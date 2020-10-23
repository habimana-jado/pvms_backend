package com.kist.pvms.dto;

import com.kist.pvms.domain.EGender;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by nizey on 8/15/2020.
 */
@Data
public class AdminDto {

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
