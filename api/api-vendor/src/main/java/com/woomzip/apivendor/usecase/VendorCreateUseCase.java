package com.woomzip.apivendor.usecase;

import com.woomzip.domainmysql.vendor.dto.request.VendorCreateRequest;
import com.woomzip.domainmysql.vendor.entity.Vendor;

public interface VendorCreateUseCase {
    void createVendor(VendorCreateRequest vendorCreateRequest);
}
