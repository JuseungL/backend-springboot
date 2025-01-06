package com.woomzip.domainmysql.vendor.service;

import com.woomzip.common.annotation.DomainService;
import com.woomzip.common.exception.apivendor.VendorException;
import com.woomzip.domainmysql.vendor.entity.Vendor;
import com.woomzip.domainmysql.vendor.repository.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import static com.woomzip.common.exception.apivendor.VendorErrorCode.VENDOR_NOT_FOUND;

@DomainService
@RequiredArgsConstructor
public class VendorQueryService {
    private final VendorRepository vendorRepository;

    @Transactional(readOnly = true)
    public Vendor findVendorById(Long id) {
        return vendorRepository.findById(id).orElseThrow(() -> new VendorException(VENDOR_NOT_FOUND));
    }
}
