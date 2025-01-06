package com.woomzip.domainmysql.vendor.service;

import com.woomzip.common.annotation.DomainService;
import com.woomzip.domainmysql.vendor.repository.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@DomainService
@RequiredArgsConstructor
public class VendorQueryService {
    private final VendorRepository vendorRepository;
//    @Transactional(readOnly = true)
}
