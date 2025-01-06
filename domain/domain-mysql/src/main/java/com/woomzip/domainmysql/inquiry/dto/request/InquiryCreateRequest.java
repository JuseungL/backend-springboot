package com.woomzip.domainmysql.inquiry.dto.request;

import com.woomzip.domainmysql.inquiry.enums.*;
import com.woomzip.domainmysql.product.entity.Product;

public record InquiryCreateRequest(
        String name,
        String additionalRequest,
        String contact,
        ResponseType responseType,
        Long productId,
        ProductType productType,
        Purpose purpose,
        Location location,
        boolean isLandOwner,
        int budget,
        LandArea landArea,
        LandSlope landSlope,
        LandAccess landAccess,
        HelpType helpType,
        StartPlan startPlan,
        Priority priority
) {
}
