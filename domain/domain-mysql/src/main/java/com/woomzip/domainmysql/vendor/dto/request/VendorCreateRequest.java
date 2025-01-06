package com.woomzip.domainmysql.vendor.dto.request;

public record VendorCreateRequest(
        String representativeName,
        String representativeImageUrl,
        String representativeIntro,
        String vendorName,
        String vendorIntro
) {}
