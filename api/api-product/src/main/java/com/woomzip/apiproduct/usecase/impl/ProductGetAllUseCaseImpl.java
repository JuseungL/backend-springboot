package com.woomzip.apiproduct.usecase.impl;

import com.woomzip.apiproduct.usecase.ProductGetAllUseCase;
import com.woomzip.common.annotation.ApplicationService;
import com.woomzip.domainmysql.product.dto.response.ProductGetAllResponse;
import com.woomzip.domainmysql.product.service.ProductQueryService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@ApplicationService
@RequiredArgsConstructor
public class ProductGetAllUseCaseImpl implements ProductGetAllUseCase {
    private final ProductQueryService productQueryService;
    @Override
    public List<ProductGetAllResponse> getAllProducts() {
        return productQueryService.getAllProducts();
    }
}
