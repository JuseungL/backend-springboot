package com.woomzip.domainmysql.vendor.service;

import com.woomzip.domainmysql.vendor.repository.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class VendorQueryService {
    private final VendorRepository vendorRepository;

}
