package com.woomzip.domainmysql.inquiry.enums;

public enum HelpType {
    SIMPLE_INQUIRY("단순 문의"),
    DETAILED_QUOTE("상세 견적서 요청"),
    SAFETY_SERVICE("토합 안심 서비스");

    private final String description;

    HelpType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
