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
 * Created by nizey on 7/29/2020.
 */
@Entity
@Data
public class Location implements Serializable{
    @Id
    private UUID id;
    private Integer state;
    private long version;
    private String code;
    private String description;
    @Enumerated(EnumType.STRING)
    private ELocationType locationType;
    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Location parentId;

    @JsonIgnore
    @OneToMany(mappedBy = "location", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    private List<Prison> prison;



}
