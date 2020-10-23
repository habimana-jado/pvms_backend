package com.kist.pvms.domain;

/**
 * Created by nizey on 7/30/2020.
 */
public enum ELocationType {
    PROVINCE("Province"),
    DISTRICT("District"),
    SECTOR("Sector"),
    CELL("Cell"),
    VILLAGE("Village");

    private String description;

    ELocationType(String description) {
        this.description = description;
    }
}
