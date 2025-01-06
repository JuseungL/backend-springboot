package com.woomzip.apivendor.usecase.impl;

import com.woomzip.apivendor.usecase.VendorCreateUseCase;
import com.woomzip.common.annotation.ApplicationService;
import com.woomzip.domainmysql.vendor.dto.request.VendorCreateRequest;
import com.woomzip.domainmysql.vendor.service.VendorCommandService;
import lombok.RequiredArgsConstructor;

@ApplicationService
@RequiredArgsConstructor
public class VendorCreateUseCaseImpl implements VendorCreateUseCase {
    private final VendorCommandService vendorCommandService;
    @Override
    public void createVendor(VendorCreateRequest vendorCreateRequest) {
        vendorCommandService.createVendor(vendorCreateRequest);
    }
}
