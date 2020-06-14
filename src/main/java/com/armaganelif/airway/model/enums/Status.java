package com.armaganelif.airway.model.enums;

public enum Status {

    ACTIVE(1),
    PASSIVE(0)
    ;

    private int val;

    Status(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}
