package com.armaganelif.airway.model.enums;

public enum Gender {

    FEMALE("FEMALE"),
    MALE("MALE")
    ;

    private String val;

    Gender(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }
}
