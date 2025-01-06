package com.woomzip.domainmysql.inquiry.dto.request;

import com.woomzip.domainmysql.inquiry.enums.*;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(description = "문의 생성에 필요한 정보")
public record InquiryCreateRequest(
        @Schema(description = "문의자의 이름", example = "홍길동", required = true)
        @NotNull(message = "문의자의 이름은 필수입니다.")
        String name,

        @Schema(description = "추가 요청사항", example = "기타 문의 사항", required = false)
        String additionalRequest,

        @Schema(description = "연락처", example = "010-1234-5678", required = true)
        @NotNull(message = "연락처는 필수입니다.")
        String contact,

        @Schema(description = "응답 방식", example = "CALL", required = true)
        @NotNull(message = "응답 방식은 필수입니다.")
        ResponseType responseType,

        @Schema(description = "관련 상품 ID", example = "1", required = false)
        Long productId,

        @Schema(description = "목적", example = "HOUSE", required = true)
        @NotNull(message = "목적은 필수입니다.")
        Purpose purpose,

        @Schema(description = "위치", example = "SEOUL", required = true)
        @NotNull(message = "위치는 필수입니다.")
        Location location,

        @Schema(description = "토지 소유 여부", example = "true", required = true)
        boolean isLandOwner,

        @Schema(description = "예산", example = "50000000", required = true)
        @NotNull(message = "예산은 필수입니다.")
        int budget,

        @Schema(description = "토지 면적", example = "UNDER_100", required = true)
        @NotNull(message = "토지 면적은 필수입니다.")
        LandArea landArea,

        @Schema(description = "토지 경사도", example = "FLAT", required = true)
        @NotNull(message = "토지 경사도는 필수입니다.")
        LandSlope landSlope,

        @Schema(description = "토지 진입도 상태", example = "WIDE", required = true)
        @NotNull(message = "토지 진입도 상태는 필수입니다.")
        LandAccess landAccess,

        @Schema(description = "필요한 도움 종류", example = "DETAILED_QUOTE", required = true)
        @NotNull(message = "필요한 도움 종류는 필수입니다.")
        HelpType helpType,

        @Schema(description = "시작 계획", example = "ASAP", required = true)
        @NotNull(message = "시작 계획은 필수입니다.")
        StartPlan startPlan,

        @Schema(description = "가장 중요하게 생각하는 사항", example = "COST_EFFICIENCY", required = true)
        @NotNull(message = "가장 중요하게 생각하는 사항은 필수입니다.")
        Priority priority
) {}
