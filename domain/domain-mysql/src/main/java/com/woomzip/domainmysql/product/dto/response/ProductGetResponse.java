package com.woomzip.domainmysql.product.dto.response;

import com.woomzip.domainmysql.product.entity.Product;
import com.woomzip.domainmysql.product.entity.ProductTemplate;
import com.woomzip.domainmysql.vendor.entity.Vendor;

import java.util.ArrayList;
import java.util.List;
public record ProductGetResponse(
        // 제휴 업체 정보
        Vendor vendor,

        // 제품 데이터
        Long productId,
        String productName,
        String productImageUrl,
        int price,
        int bedroom,
        Integer bathroom,
        Double realUsableArea,
        Double buildingArea,
        int warrantyPeriod,
        String specialFeature,
        String structureMaterial,
        String wallMaterial,
        String insulationMaterial,
        String heatingMethod,
        String interiorMaterial,
        String windowMaterial,
        String exteriorMaterial,
        String roofMaterial,
        String kitchenMaterial,
        String bathroomMaterial,
        String lightingMaterial,
        String includedFurniture,
        String otherDetail,
        String priceIncludes,

        // 템플릿
        List<FullResponse> fullTemplates,
        List<HalfResponse> halfTemplates,
        CardEntireResponse cardEntireResponse,
        List<MasterPlanResponse> masterPlanTemplates
) {
    public record FullResponse(
            Long templateId,
            String title,
            String description,
            String productTemplateImageUrl,
            int index
    ) {}

    public record HalfResponse(
            Long templateId,
            String title,
            String description,
            String productTemplateImageUrl,
            int index
    ) {}

    public record CardEntireResponse(
            String cardTemplateTitle,
            String cardTemplateDescription,
            List<CardResponse> cardResponses
    ) {}

    public record CardResponse(
            Long templateId,
            String title,
            String description,
            String productTemplateImageUrl,
            int index
    ) {}

    public record MasterPlanResponse(
            Long templateId,
            String title,
            String description,
            String productTemplateImageUrl,
            int index
    ) {}

    public static ProductGetResponse fromProduct(Product product) {
        // 템플릿 처리
        List<FullResponse> fullTemplates = new ArrayList<>();
        List<HalfResponse> halfTemplates = new ArrayList<>();
        List<CardResponse> cardTemplates = new ArrayList<>();
        List<MasterPlanResponse> masterPlanTemplates = new ArrayList<>();
        CardEntireResponse cardEntireResponse = null;

        for (ProductTemplate template : product.getProductTemplates()) {
            switch (template.getProductTemplateType()) {
                case FULL:
                    fullTemplates.add(new FullResponse(
                            template.getId(),
                            template.getTitle(),
                            template.getDescription(),
                            template.getProductTemplateImageUrl(),
                            template.getIndex()
                    ));
                    break;
                case HALF:
                    halfTemplates.add(new HalfResponse(
                            template.getId(),
                            template.getTitle(),
                            template.getDescription(),
                            template.getProductTemplateImageUrl(),
                            template.getIndex()
                    ));
                    break;
                case CARD:
                    cardTemplates.add(new CardResponse(
                            template.getId(),
                            template.getTitle(),
                            template.getDescription(),
                            template.getProductTemplateImageUrl(),
                            template.getIndex()
                    ));
                    break;
                case CARD_TITLE:
                    // CARD_TITLE 템플릿을 찾으면 CardEntireResponse 생성
                    if (cardEntireResponse == null) {
                        String cardTitle = template.getTitle();
                        String description = template.getDescription();
                        cardEntireResponse = new CardEntireResponse(cardTitle, description,cardTemplates);
                    }
                    break;
                case MASTER_PLAN:
                    masterPlanTemplates.add(new MasterPlanResponse(
                            template.getId(),
                            template.getTitle(),
                            template.getDescription(),
                            template.getProductTemplateImageUrl(),
                            template.getIndex()
                    ));
                    break;
                default:
                    break;
            }
        }

        return new ProductGetResponse(
                product.getVendor(),
                product.getId(),
                product.getProductName(),
                product.getProductImageUrl(),
                product.getPrice(),
                product.getBedroom(),
                product.getBathroom(),
                product.getRealUsableArea(),
                product.getBuildingArea(),
                product.getWarrantyPeriod(),
                product.getSpecialFeature(),
                product.getStructureMaterial(),
                product.getWallMaterial(),
                product.getInsulationMaterial(),
                product.getHeatingMethod(),
                product.getInteriorMaterial(),
                product.getWindowMaterial(),
                product.getExteriorMaterial(),
                product.getRoofMaterial(),
                product.getKitchenMaterial(),
                product.getBathroomMaterial(),
                product.getLightingMaterial(),
                product.getIncludedFurniture(),
                product.getOtherDetail(),
                product.getPriceIncludes(),
                fullTemplates,
                halfTemplates,
                cardEntireResponse,
                masterPlanTemplates
        );
    }
}
