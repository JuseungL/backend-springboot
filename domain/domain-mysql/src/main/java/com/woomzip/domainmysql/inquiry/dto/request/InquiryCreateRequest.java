package com.woomzip.domainmysql.inquiry.dto.request;

import com.woomzip.domainmysql.inquiry.enums.*;
import com.woomzip.domainmysql.product.entity.Product;

public record InquiryCreateRequest(
        String name,
        String additionalRequest,
        String contact,
        ResponseType responseType,
        Long productId, // Product 엔티티의 ID를 받아오기 위해
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
    // 필요한 변환 메서드를 작성할 수 있습니다.
    public Product toProduct() {
        if (productId != null) {
            return new Product(productId);
        } else {
            return null;
        }
    }
}
