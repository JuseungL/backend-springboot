package com.woomzip.apiproduct.usecase.impl;

import com.woomzip.apiproduct.usecase.ProductGetUseCase;
import com.woomzip.common.annotation.ApplicationService;
import com.woomzip.domainmysql.product.dto.response.ProductGetResponse;
import com.woomzip.domainmysql.product.service.ProductQueryService;
import lombok.RequiredArgsConstructor;

@ApplicationService

@RequiredArgsConstructor
public class ProductGetUseCaseImpl implements ProductGetUseCase {
    private final ProductQueryService productQueryService;
    @Override
    public ProductGetResponse getProduct(Long productId) {
        return productQueryService.getProduct(productId);
    }
}
