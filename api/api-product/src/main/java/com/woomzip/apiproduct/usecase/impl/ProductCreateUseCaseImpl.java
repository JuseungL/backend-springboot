package com.woomzip.apiproduct.usecase.impl;

import com.woomzip.apiproduct.usecase.ProductCreateUseCase;
import com.woomzip.common.annotation.ApplicationService;
import com.woomzip.domainmysql.product.dto.request.ProductCreateRequest;
import com.woomzip.domainmysql.product.service.ProductCommandService;
import com.woomzip.domainmysql.vendor.entity.Vendor;
import com.woomzip.domainmysql.vendor.service.VendorQueryService;
import lombok.RequiredArgsConstructor;

import java.util.LinkedList;

@ApplicationService
@RequiredArgsConstructor
public class ProductCreateUseCaseImpl implements ProductCreateUseCase {
    private final ProductCommandService productCommandService;
    private final VendorQueryService vendorQueryService;
    @Override
    public void createProduct(ProductCreateRequest productCreateRequest) {
        Vendor vendorById = vendorQueryService.findVendorById(productCreateRequest.vendorId());
        productCommandService.createProduct(productCreateRequest, vendorById);
    }
}
