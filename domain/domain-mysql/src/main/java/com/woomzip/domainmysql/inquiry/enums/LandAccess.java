package com.woomzip.domainmysql.inquiry.enums;

public enum LandAccess {
    WIDE("넓음"),
    NARROW("조금 좁음"),
    VERY_NARROW("많이 좁음");

    private final String description;

    LandAccess(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
