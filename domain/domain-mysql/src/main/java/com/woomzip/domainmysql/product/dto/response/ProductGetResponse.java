package com.woomzip.domainmysql.product.dto.response;

import com.woomzip.domainmysql.product.entity.Product;
import com.woomzip.domainmysql.product.entity.ProductTemplate;

import java.util.List;
import java.util.stream.Collectors;

public record ProductGetResponse(
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
        Long vendorId,
        String vendorName,
        List<ProductTemplateResponse> productTemplates
) {

    // Nested static record for product template response
    public record ProductTemplateResponse(
            Long templateId,
            String title,
            String description,
            String productTemplateImageUrl,
            String productTemplateType,
            int index
    ) {}

    // Static method to map Product entity to ProductGetResponse DTO
    public static ProductGetResponse fromProduct(Product product) {
        // Map the Vendor entity to vendorId and vendorName
        Long vendorId = product.getVendor().getId();
        String vendorName = product.getVendor().getVendorName(); // assuming there's a getName() method in Vendor

        // Map the associated ProductTemplates
        List<ProductTemplateResponse> productTemplates = product.getProductTemplates().stream()
                .map(template -> new ProductTemplateResponse(
                        template.getId(),
                        template.getTitle(),
                        template.getDescription(),
                        template.getProductTemplateImageUrl(),
                        template.getProductTemplateType().getDescription(),
                        template.getIndex()
                ))
                .collect(Collectors.toList());

        // Return the ProductGetResponse DTO
        return new ProductGetResponse(
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
                vendorId,
                vendorName,
                productTemplates
        );
    }
}
