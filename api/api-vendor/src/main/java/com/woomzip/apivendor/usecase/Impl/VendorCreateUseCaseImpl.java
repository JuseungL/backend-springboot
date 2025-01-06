package com.woomzip.apivendor.usecase.Impl;

import com.woomzip.apivendor.usecase.VendorCreateUseCase;
import com.woomzip.common.annotation.ApplicationService;
import com.woomzip.domainmysql.vendor.dto.request.VendorCreateRequest;
import com.woomzip.domainmysql.vendor.entity.Vendor;
import com.woomzip.domainmysql.vendor.service.VendorCommandService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@ApplicationService
public class VendorCreateUseCaseImpl implements VendorCreateUseCase {
    private final VendorCommandService vendorCommandService;
    @Override
    public void createVendor(VendorCreateRequest vendorCreateRequest) {
        vendorCommandService.createVendor(vendorCreateRequest);
    }
}
