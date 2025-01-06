package com.woomzip.domainmysql.product.dto.request;

import com.woomzip.domainmysql.product.enums.ProductTemplateType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record ProductCreateRequest(
        @Schema(description = "제품 이름", example = "예시 제품", required = true)
        @NotNull(message = "제품 이름은 필수입니다.")
        String productName,

        @Schema(description = "제품 이미지", example = "https://image1.jpg", required = true)
        @NotNull(message = "제품 이미지는 필수입니다.")
        String productImageUrl,

        @Schema(description = "가격", example = "500000", required = true)
        @NotNull(message = "가격은 필수입니다.")
        int price,

        @Schema(description = "침실 개수", example = "3", required = true)
        @NotNull(message = "침실 개수는 필수입니다.")
        int bedroom,

        @Schema(description = "욕실 개수", example = "2", required = true)
        Integer bathroom,

        @Schema(description = "실사용 평수", example = "30.5", required = true)
        Double realUsableArea,

        @Schema(description = "건축 면적", example = "50.0", required = true)
        Double buildingArea,

        @Schema(description = "AS 보증기간", example = "1", required = true)
        @NotNull(message = "AS 보증기간은 필수입니다.")
        int warrantyPeriod,

        @Schema(description = "제품 특이사항", example = "특이사항 없음", required = false)
        String specialFeature,

        @Schema(description = "구조자재", example = "철근", required = false)
        String structureMaterial,

        @Schema(description = "벽체자재", example = "시멘트", required = false)
        String wallMaterial,

        @Schema(description = "단열자재", example = "스티로폼", required = false)
        String insulationMaterial,

        @Schema(description = "난방방법", example = "가스", required = false)
        String heatingMethod,

        @Schema(description = "내장자재", example = "목재", required = false)
        String interiorMaterial,

        @Schema(description = "창호자재", example = "PVC", required = false)
        String windowMaterial,

        @Schema(description = "외장자재", example = "석재", required = false)
        String exteriorMaterial,

        @Schema(description = "지붕자재", example = "철판", required = false)
        String roofMaterial,

        @Schema(description = "주방자재", example = "대리석", required = false)
        String kitchenMaterial,

        @Schema(description = "욕실자재", example = "세라믹", required = false)
        String bathroomMaterial,

        @Schema(description = "조명자재", example = "LED", required = false)
        String lightingMaterial,

        @Schema(description = "포함가구", example = "없음", required = false)
        String includedFurniture,

        @Schema(description = "기타사항", example = "기타 사항 없음", required = false)
        String otherDetail,

        @Schema(description = "업체 ID", example = "1", required = true)
        @NotNull(message = "디자인 및 제작사 ID는 필수입니다.")
        Long vendorId,

        @Schema(description = "가격에 포함된 사항", example = "배달비 포함", required = false)
        String priceIncludes,

        @Schema(description = "템플릿 목록", required = true)
        @NotNull(message = "템플릿 목록은 필수입니다.")
        List<ProductTemplateRequest> templates
) {

    public record ProductTemplateRequest(
            @Schema(description = "템플릿 제목", example = "기본 템플릿", required = true)
            @NotNull(message = "템플릿 제목은 필수입니다.")
            String title,

            @Schema(description = "템플릿 설명", example = "기본 설명", required = false)
            String description,

            @Schema(description = "제품 템플릿 이미지 URL", example = "http://example.com/image.jpg", required = false)
            String productTemplateImageUrl,

            @Schema(description = "템플릿 유형", example = "FULL", required = true)
            @NotNull(message = "템플릿 유형은 필수입니다.")
            ProductTemplateType productTemplateType,

            @Schema(description = "템플릿 인덱스", example = "1", required = true)
            @NotNull(message = "템플릿 인덱스는 필수입니다.")
            int index
    ) {}
}
