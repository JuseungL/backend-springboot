package com.woomzip.domainmysql.inquiry.enums;

public enum LandArea {
    UNDER_50("50평 이하"),
    UNDER_75("75평 이하"),
    UNDER_100("100평 이하"),
    UNDER_125("125평 이하"),
    UNDER_150("150평 이하"),
    OVER_150("150평 초과");

    private final String description;

    LandArea(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
