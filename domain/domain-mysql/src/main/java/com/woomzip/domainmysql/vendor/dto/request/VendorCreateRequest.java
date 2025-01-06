package com.woomzip.domainmysql.vendor.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(description = "모듈러 주택 제작 업체 등록 요청 데이터")
public record VendorCreateRequest(
        @Schema(description = "업체 대표자 이름", example = "홍길동", required = true)
        @NotNull(message = "업체 대표자 이름은 필수입니다.")
        String representativeName,

        @Schema(description = "업체 대표자 이미지 URL", example = "https://example.com/image.jpg", required = true)
        @NotNull(message = "업체 대표자 이미지 URL은 필수입니다.")
        String representativeImageUrl,

        @Schema(description = "업체 대표자 소개", example = "업체의 대표인 홍길동입니다.", required = true)
        @NotNull(message = "업체 대표자 소개는 필수입니다.")
        String representativeIntro,

        @Schema(description = "업체 이름", example = "모듈러 주택 업체", required = true)
        @NotNull(message = "업체 이름은 필수입니다.")
        String vendorName,

        @Schema(description = "업체 소개", example = "모듈러 주택을 전문으로 제작하는 업체입니다.", required = true)
        @NotNull(message = "업체 소개는 필수입니다.")
        String vendorIntro
) {}
