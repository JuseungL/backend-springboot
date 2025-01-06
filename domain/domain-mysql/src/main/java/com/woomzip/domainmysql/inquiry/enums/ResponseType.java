package com.woomzip.domainmysql.inquiry.enums;

public enum ResponseType {
    CALL("전화"),
    MESSAGE("문자");

    private final String description;

    ResponseType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
