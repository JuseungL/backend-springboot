package com.woomzip.domainmysql.inquiry.enums;

public enum Location {
    SEOUL("서울"),
    GYEONGGI("경기도"),
    GANGWON("강원도"),
    CHUNGBUK("충청북도"),
    CHUNGNAM("충청남도"),
    GYEONGBUK("경상북도"),
    GYEONGNAM("경상남도"),
    JEONBUK("전라북도"),
    JEONNAM("전라남도"),
    JEJU("제주도");

    private final String description;

    Location(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
