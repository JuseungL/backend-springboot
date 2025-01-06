package com.woomzip.domainmysql.inquiry.enums;

public enum StartPlan {
    ASAP("최대한 빠르게"),
    FLEXIBLE("조금 여유가 있어요"),
    UNDECIDED("미정");

    private final String description;

    StartPlan(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
