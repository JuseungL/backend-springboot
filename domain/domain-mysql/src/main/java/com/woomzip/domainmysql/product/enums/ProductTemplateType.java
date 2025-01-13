package com.woomzip.domainmysql.product.enums;

import lombok.Getter;

@Getter
public enum ProductTemplateType {
    FULL("FULL"),
    HALF("HALF"),
    CARD_TITLE("CARD_TITLE"),
    CARD("CARD"),
    MASTER_PLAN("MASTER_PLAN");

    private final String description;

    ProductTemplateType(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }

}

