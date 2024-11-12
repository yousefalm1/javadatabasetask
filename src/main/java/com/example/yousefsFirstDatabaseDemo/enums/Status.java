package com.example.yousefsFirstDatabaseDemo.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {
    ACTIVE, INACTIVE;


    // This tells how to create a Status enum from a string
    @JsonCreator
    public static Status fromString(String status) {
        return Status.valueOf(status.toUpperCase());
    }

    @JsonValue
    public String toValue() {
        return this.name();
    }


    // Thisn checks if the status provided s either "ACTIVE" or "INACTIVE", no matter the letter case
    public static boolean isValidStatus(String status) {
        for (Status s : Status.values()) {
            if (s.name().equalsIgnoreCase(status)) {
                return true;
            }
        }
        return false;
    }

}