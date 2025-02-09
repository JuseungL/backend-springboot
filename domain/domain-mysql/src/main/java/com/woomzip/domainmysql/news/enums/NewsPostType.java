package com.woomzip.domainmysql.news.enums;

import lombok.Getter;

@Getter
public enum NewsPostType {
    NEWS("NEWS"),
    NOTICE("NOTICE");

    private final String description;

    NewsPostType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}