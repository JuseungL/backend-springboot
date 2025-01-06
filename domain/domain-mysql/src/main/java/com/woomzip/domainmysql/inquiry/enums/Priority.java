package com.woomzip.domainmysql.inquiry.enums;

public enum Priority {
    COST_EFFICIENCY("가성비"),
    QUALITY("완성도"),
    TRUST("신뢰도");

    private final String description;

    Priority(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
