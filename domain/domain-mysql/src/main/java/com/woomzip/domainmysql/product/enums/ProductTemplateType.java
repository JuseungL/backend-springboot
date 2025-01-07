package com.woomzip.domainmysql.product.enums;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "제품 템플릿 타입")
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
