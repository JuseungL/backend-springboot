package com.woomzip.domainmysql.inquiry.enums;

public enum ProductType {
    HOUSE("주택"),
    SHELTER("체류형쉼터 및 농막");

    private final String description;

    ProductType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
