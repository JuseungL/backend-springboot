package com.woomzip.domainmysql.inquiry.enums;

public enum LandSlope {
    FLAT("평평함"),
    SLIGHT_SLOPE("조금 경사짐"),
    STEEP_SLOPE("많이 경사짐");

    private final String description;

    LandSlope(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
