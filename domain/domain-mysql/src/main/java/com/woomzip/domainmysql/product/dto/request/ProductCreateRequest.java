package com.woomzip.domainmysql.product.dto.request;

import com.woomzip.domainmysql.product.entity.Product;
import com.woomzip.domainmysql.product.entity.ProductTemplate;
import com.woomzip.domainmysql.product.enums.ProductTemplateType;
import com.woomzip.domainmysql.vendor.entity.Vendor;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;


@Schema(description = "제품 생성 요청 DTO")
public record ProductCreateRequest(
        @Schema(description = "제품 이름", example = "예시 제품", required = true)
        @NotNull(message = "제품 이름은 필수입니다.")
        @Size(max = 30, message = "제품명은 최대 30자까지 입력 가능합니다.")
        String productName,

        @Schema(description = "제품 설명", example = "제품에 대한 설명입니다.", required = true)
        @NotNull(message = "제품 설명은 필수입니다.")
        @Size(max = 255, message = "제품 설명은 최대 255자까지 입력 가능합니다.")
        String productIntro,

        @Schema(description = "제품 이미지", example = "https://image1.jpg", required = true)
        @NotNull(message = "제품 이미지는 필수입니다.")
        @Size(max = 255, message = "제품 대표 이미지 URL은 최대 255자까지 입력 가능합니다.")
        String productImageUrl,

        @Schema(description = "가격", example = "500000", required = true)
        @NotNull(message = "가격은 필수입니다.")
        int price,

        @Schema(description = "침실 개수", example = "3", required = true)
        @NotNull(message = "침실 개수는 필수입니다.")
        int bedroom,

        @Schema(description = "욕실 개수(소숫점 한자리까지)", example = "2", required = true)
        @NotNull(message = "욕실 개수는 필수입니다.")
        int bathroom,

        @Schema(description = "실사용 평수(소숫점 한자리까지)", example = "30.5", required = true)
        @Digits(integer = 5, fraction = 1, message = "소수점 한 자리까지 허용됩니다.")
        @NotNull(message = "실사용 평수는 필수입니다.")
        Double realUsableArea,

        @Schema(description = "건축 면적(소숫점 한자리까지)", example = "50.0", required = true)
        @Digits(integer = 3, fraction = 1, message = "소수점 한 자리까지 허용됩니다.")
        @NotNull(message = "건축 면적은 필수입니다.")
        Double buildingArea,

        @Schema(description = "AS 보증기간", example = "1", required = true)
        @NotNull(message = "AS 보증기간은 필수입니다.")
        int warrantyPeriod,

        @Schema(description = "제품 특이사항", example = "특이사항 없음", required = false)
        @Size(max = 255, message = "제품 특이사항은 최대 255자까지 입력 가능합니다.")
        String specialFeature,

        @Schema(description = "구조자재", example = "철근", required = false)
        @Size(max = 255, message = "구조자재 최대 255자까지 입력 가능합니다.")
        String structureMaterial,

        @Schema(description = "벽체자재", example = "시멘트", required = false)
        @Size(max = 255, message = "벽체자제은 최대 255자까지 입력 가능합니다.")
        String wallMaterial,

        @Schema(description = "단열자재", example = "스티로폼", required = false)
        @Size(max = 255, message = "단열자재는 최대 255자까지 입력 가능합니다.")
        String insulationMaterial,

        @Schema(description = "난방방법", example = "가스", required = false)
        @Size(max = 255, message = "난방방법은 최대 255자까지 입력 가능합니다.")
        String heatingMethod,

        @Schema(description = "내장자재", example = "목재", required = false)
        @Size(max = 255, message = "내장자재는 최대 255자까지 입력 가능합니다.")
        String interiorMaterial,

        @Schema(description = "창호자재", example = "PVC", required = false)
        @Size(max = 255, message = "창호자재는 최대 255자까지 입력 가능합니다.")
        String windowMaterial,

        @Schema(description = "외장자재", example = "석재", required = false)
        @Size(max = 255, message = "외장자재는 최대 255자까지 입력 가능합니다.")
        String exteriorMaterial,

        @Schema(description = "지붕자재", example = "철판", required = false)
        @Size(max = 255, message = "지붕자재는 최대 255자까지 입력 가능합니다.")
        String roofMaterial,

        @Schema(description = "주방자재", example = "대리석", required = false)
        @Size(max = 255, message = "주방자재는 최대 255자까지 입력 가능합니다.")
        String kitchenMaterial,

        @Schema(description = "욕실자재", example = "세라믹", required = false)
        @Size(max = 255, message = "욕실자재는 최대 255자까지 입력 가능합니다.")
        String bathroomMaterial,

        @Schema(description = "조명자재", example = "LED", required = false)
        @Size(max = 255, message = "조명자재는 최대 255자까지 입력 가능합니다.")
        String lightingMaterial,

        @Schema(description = "포함가구", example = "없음", required = false)
        @Size(max = 255, message = "포함가구는 최대 255자까지 입력 가능합니다.")
        String includedFurniture,

        @Schema(description = "기타사항", example = "기타 사항 없음", required = false)
        @Size(max = 500, message = "기타사항은 최대 500자까지 입력 가능합니다.")
        String otherDetail,

        @Schema(description = "가격에 포함된 사항", example = "배달비 포함", required = false)
        @Size(max = 500, message = "가격에 포함된 사항은 최대 500자까지 입력 가능합니다.")
        String priceIncludes,

        @Schema(description = "업체 ID", example = "1", required = true)
        @NotNull(message = "제휴 업체 ID는 필수입니다.")
        Long vendorId,

        @Schema(description = "제품 템플릿 목록", required = true)
        List<ProductTemplateCreateRequest> productTemplates
) {
        public static Product toEntity(ProductCreateRequest request, Vendor vendor) {
                return new Product(
                        request.productName(),
                        request.productIntro(),
                        request.productImageUrl(),
                        request.price(),
                        request.bedroom(),
                        request.bathroom(),
                        request.realUsableArea(),
                        request.buildingArea(),
                        request.warrantyPeriod(),
                        request.specialFeature(),
                        request.structureMaterial(),
                        request.wallMaterial(),
                        request.insulationMaterial(),
                        request.heatingMethod(),
                        request.interiorMaterial(),
                        request.windowMaterial(),
                        request.exteriorMaterial(),
                        request.roofMaterial(),
                        request.kitchenMaterial(),
                        request.bathroomMaterial(),
                        request.lightingMaterial(),
                        request.includedFurniture(),
                        request.otherDetail(),
                        vendor,
                        request.priceIncludes()
                );
        }

        public record ProductTemplateCreateRequest(
            @Schema(description = "템플릿 제목", example = "주변 풍경 뷰", required = true)
            @NotNull(message = "템플릿 제목은 필수입니다.")
            @Size(max = 50, message = "가격에 포함된 사항은 최대 50자까지 입력 가능합니다.")
            String title,

            @Schema(description = "템플릿 설명", example = "보시는 것과 같이 주변 풍경이 아름답습니다.", required = false)
            @Size(max = 500, message = "템플릿에서 제품 설명은 최대 500자까지 입력 가능합니다.")
            String description,

            @Schema(description = "제품 템플릿 이미지 URL", example = "http://example.com/image.jpg", required = false)
            @Size(max = 65535, message = "템플릿에서 제품 설명은 최대 65,535자까지 입력 가능합니다.")
            String productTemplateImageUrl,

            @Schema(description = "템플릿 유형", example = "FULL", required = true)
            @NotNull(message = "템플릿 유형은 필수입니다.")
            ProductTemplateType productTemplateType,

            @Schema(description = "템플릿 인덱스", example = "1", required = true)
            @NotNull(message = "템플릿 인덱스는 필수입니다.")
            Long index
        ) {
                public static ProductTemplate toEntity(ProductTemplateCreateRequest templateRequest, Product product) {
                        return new ProductTemplate(
                                templateRequest.title(),
                                templateRequest.description(),
                                templateRequest.productTemplateImageUrl(),
                                product,
                                templateRequest.productTemplateType(),
                                templateRequest.index()
                        );
                }
        }
}
