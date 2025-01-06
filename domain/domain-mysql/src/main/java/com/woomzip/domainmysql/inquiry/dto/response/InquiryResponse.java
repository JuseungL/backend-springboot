package com.woomzip.domainmysql.inquiry.dto.response;

import com.woomzip.domainmysql.inquiry.entity.Inquiry;

public record InquiryResponse(
        Long id,
        String name,
        String contact,
        String additionalRequest,
        Long productId,
        String responseType,
        String purpose,
        String location,
        boolean isLandOwner,
        int budget,
        String landArea,
        String landSlope,
        String landAccess,
        String helpType,
        String startPlan,
        String priority
) {
    public static InquiryResponse from(Inquiry inquiry) {
        return new InquiryResponse(
                inquiry.getId(),
                inquiry.getName(),
                inquiry.getContact(),
                inquiry.getAdditionalRequest(),
                inquiry.getProductId(),
                inquiry.getResponseType().getDescription(),
                inquiry.getPurpose().getDescription(),
                inquiry.getLocation().getDescription(),
                inquiry.isLandOwner(),
                inquiry.getBudget(),
                inquiry.getLandArea().getDescription(),
                inquiry.getLandSlope().getDescription(),
                inquiry.getLandAccess().getDescription(),
                inquiry.getHelpType().getDescription(),
                inquiry.getStartPlan().getDescription(),
                inquiry.getPriority().getDescription()
        );
    }
}