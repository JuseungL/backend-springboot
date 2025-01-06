package com.woomzip.domainmysql.inquiry.enums;

public enum Purpose {
    SHELTER("체류형 쉼터 및 농막"),
    HOUSE("주택");

    private final String description;

    Purpose(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
