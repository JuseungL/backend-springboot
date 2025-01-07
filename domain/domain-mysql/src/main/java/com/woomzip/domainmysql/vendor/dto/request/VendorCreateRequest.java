package com.woomzip.domainmysql.vendor.dto.request;

import com.woomzip.domainmysql.vendor.entity.Vendor;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Schema(description = "모듈러 주택 제작 업체 등록 요청 데이터")
public record VendorCreateRequest(
        @Schema(description = "업체 대표자 이름 (최대 20자)", example = "양준우", required = true)
        @NotNull(message = "업체 대표자 이름은 필수입니다.")
        @Size(max = 20, message = "업체 대표자 이름은 최대 20자까지 가능합니다.")
        String representativeName,

        @Schema(description = "업체 대표자 이미지 URL (최대 500자)", example = "https://example.com/image.jpg", required = true)
        @NotNull(message = "업체 대표자 이미지 URL은 필수입니다.")
        @Size(max = 255, message = "업체 대표자 이미지 URL은 최대 500자까지 가능합니다.")
        String representativeImageUrl,

        @Schema(description = "업체 대표자 소개 (최대 500자)", example = "움집의 대표인 양준우입니다.", required = true)
        @NotNull(message = "업체 대표자 소개는 필수입니다.")
        @Size(max = 500, message = "업체 대표자 소개는 최대 500자까지 가능합니다.")
        String representativeIntro,

        @Schema(description = "업체 이름 (최대 20자)", example = "움집", required = true)
        @NotNull(message = "업체 이름은 필수입니다.")
        @Size(max = 20, message = "업체 이름은 최대 20자까지 가능합니다.")
        String vendorName,

        @Schema(description = "업체 소개 (최대 500자)", example = "움집은 모듈러 주택을 전문으로 제작하는 업체입니다.", required = true)
        @NotNull(message = "업체 소개는 필수입니다.")
        @Size(max = 500, message = "업체 소개는 최대 500자까지 가능합니다.")
        String vendorIntro
) {
        public static Vendor toEntity(VendorCreateRequest vendorCreateRequest) {
                return Vendor.builder()
                        .representativeName(vendorCreateRequest.representativeName())
                        .representativeImageUrl(vendorCreateRequest.representativeImageUrl())
                        .representativeIntro(vendorCreateRequest.representativeIntro())
                        .vendorName(vendorCreateRequest.vendorName())
                        .vendorIntro(vendorCreateRequest.vendorIntro())
                        .build();
        }
}
