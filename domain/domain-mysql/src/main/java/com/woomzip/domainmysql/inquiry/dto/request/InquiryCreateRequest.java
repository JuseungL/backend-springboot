package com.woomzip.domainmysql.inquiry.dto.request;

import com.woomzip.domainmysql.inquiry.enums.*;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "문의 생성에 필요한 정보")
public record InquiryCreateRequest(
        @Schema(description = "문의자의 이름", example = "홍길동", required = true)
        String name,

        @Schema(description = "추가 요청사항", example = "기타 문의 사항", required = false)
        String additionalRequest,

        @Schema(description = "연락처", example = "010-1234-5678", required = true)
        String contact,

        @Schema(description = "응답 방식", example = "CALL", required = true)
        ResponseType responseType,

        @Schema(description = "관련 상품 ID", example = "1", required = false)
        Long productId,

        @Schema(description = "목적", example = "HOUSE", required = true)
        Purpose purpose,

        @Schema(description = "위치", example = "SEOUL", required = true)
        Location location,

        @Schema(description = "토지 소유 여부", example = "true", required = true)
        boolean isLandOwner,

        @Schema(description = "예산", example = "50000000", required = true)
        int budget,

        @Schema(description = "토지 면적", example = "OVER_100", required = true)
        LandArea landArea,

        @Schema(description = "토지 경사도", example = "FLAT", required = true)
        LandSlope landSlope,

        @Schema(description = "토지 진입도 상태", example = "WIDE", required = true)
        LandAccess landAccess,

        @Schema(description = "필요한 도움 종류", example = "DETAILED_QUOTE", required = true)
        HelpType helpType,

        @Schema(description = "시작 계획", example = "ASAP", required = true)
        StartPlan startPlan,

        @Schema(description = "가장 중요하게 생각하는 사항", example = "COST_EFFECTIVENESS", required = true)
        Priority priority
) {
}
