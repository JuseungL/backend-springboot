package com.woomzip.domainmysql.vendor.service;

import com.woomzip.domainmysql.vendor.dto.request.VendorCreateRequest;
import com.woomzip.domainmysql.vendor.entity.Vendor;
import com.woomzip.domainmysql.vendor.repository.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class VendorCommandService {
    private final VendorRepository vendorRepository;

    @Transactional
    public Vendor createVendor(VendorCreateRequest vendorCreateRequest) {
        Vendor vendor = Vendor.builder()
                .representativeName(vendorCreateRequest.representativeName())
                .representativeImageUrl(vendorCreateRequest.representativeImageUrl())
                .representativeIntro(vendorCreateRequest.representativeIntro())
                .vendorName(vendorCreateRequest.vendorName())
                .vendorIntro(vendorCreateRequest.vendorIntro())
                .build();

        return vendorRepository.save(vendor);
    }
}
