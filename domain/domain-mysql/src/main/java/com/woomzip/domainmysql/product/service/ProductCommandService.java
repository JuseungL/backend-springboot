package com.woomzip.domainmysql.product.service;

import com.woomzip.common.annotation.DomainService;
import com.woomzip.domainmysql.product.dto.request.ProductCreateRequest;
import com.woomzip.domainmysql.product.entity.Product;
import com.woomzip.domainmysql.product.entity.ProductTemplate;
import com.woomzip.domainmysql.product.repository.ProductRepository;
import com.woomzip.domainmysql.product.repository.ProductTemplateRepository;
import com.woomzip.domainmysql.vendor.entity.Vendor;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@DomainService
@RequiredArgsConstructor
public class ProductCommandService {

    private final ProductRepository productRepository;
    private final ProductTemplateRepository productTemplateRepository;

    // 제품 생성 메서드
    @Transactional
    public Product createProduct(ProductCreateRequest request, Vendor vendor) {
        // 제품 엔티티 생성
        Product product = new Product(
                request.productName(),
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

        productRepository.save(product);

        // 템플릿 목록 저장
        List<ProductTemplate> templates = request.templates().stream()
                .map(templateRequest -> new ProductTemplate(
                        templateRequest.title(),
                        templateRequest.description(),
                        templateRequest.productImageUrl(),
                        product,
                        templateRequest.productTemplateType(),
                        templateRequest.index()
                ))
                .toList();
        productTemplateRepository.saveAll(templates);

        return product;
    }

    // 제품 조회 메서드
//    public Product getProductById(Long productId) {
//        return productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
//    }
//
//    // 템플릿 조회 메서드
//    public List<ProductTemplate> getProductTemplates(Long productId) {
//        return productTemplateRepository.findByProductId(productId);
//    }
}
