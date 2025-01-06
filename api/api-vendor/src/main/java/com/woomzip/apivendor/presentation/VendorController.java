package com.woomzip.apivendor.presentation;

import com.woomzip.apivendor.usecase.Impl.VendorCreateUseCaseImpl;
import com.woomzip.apivendor.usecase.VendorCreateUseCase;
import com.woomzip.common.response.ApplicationResponse;
import com.woomzip.domainmysql.vendor.dto.request.VendorCreateRequest;
import com.woomzip.domainmysql.vendor.entity.Vendor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/vendors")
public class VendorController {
    private final VendorCreateUseCase vendorCreateUseCase;
    @PostMapping
    public ApplicationResponse<String> createVendor(@RequestBody VendorCreateRequest vendorCreateRequest) {
        vendorCreateUseCase.createVendor(vendorCreateRequest);
        return ApplicationResponse.created("모듈러 주택 제작 업체 등록 성공");
    }
}
