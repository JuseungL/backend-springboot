package com.woomzip.domainmysql.product.service;

import com.woomzip.common.annotation.DomainService;
import com.woomzip.domainmysql.product.dto.response.ProductGetAllResponse;
import com.woomzip.domainmysql.product.dto.response.ProductGetResponse;
import com.woomzip.domainmysql.product.entity.Product;
import com.woomzip.domainmysql.product.entity.ProductTemplate;
import com.woomzip.domainmysql.product.repository.ProductRepository;
import com.woomzip.domainmysql.product.repository.ProductTemplateRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@DomainService
@RequiredArgsConstructor
public class ProductQueryService {
    private final ProductRepository productRepository;
    private final ProductTemplateRepository productTemplateRepository;

    public List<ProductGetAllResponse> getAllProducts() {
        // Fetch all products
        List<Product> products = productRepository.findAll();

        // Map products to ProductGetAllResponse DTO
        return products.stream()
                .map(product -> ProductGetAllResponse.builder()
                        .id(product.getId())
                        .productName(product.getProductName())
                        .realUsableArea(product.getRealUsableArea())
                        .bedroom(product.getBedroom())
                        .bathroom(product.getBathroom())
                        .price(product.getPrice())
                        .productImageUrl(product.getProductImageUrl())
                        .build())
                .collect(Collectors.toList());
    }

    public ProductGetResponse getProduct(Long productId) {
        Product byIdOrThrow = productRepository.findByIdOrThrow(productId);
        return ProductGetResponse.fromProduct(byIdOrThrow);

    }
}
