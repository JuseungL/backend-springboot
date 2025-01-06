package com.woomzip.domainmysql.inquiry.service;

import com.woomzip.common.annotation.DomainService;
import com.woomzip.domainmysql.inquiry.dto.request.InquiryCreateRequest;
import com.woomzip.domainmysql.inquiry.entity.Inquiry;
import com.woomzip.domainmysql.product.entity.Product;
import com.woomzip.domainmysql.inquiry.repository.InquiryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@DomainService
@RequiredArgsConstructor
public class InquiryCommandService {
    private final InquiryRepository inquiryRepository;

    @Transactional
    public Inquiry createInquiry(InquiryCreateRequest request) {

        Inquiry inquiry = Inquiry.builder()
                .name(request.name())
                .additionalRequest(request.additionalRequest())
                .contact(request.contact())
                .responseType(request.responseType())
                .productId(request.productId())
                .purpose(request.purpose())
                .location(request.location())
                .isLandOwner(request.isLandOwner())
                .budget(request.budget())
                .landArea(request.landArea())
                .landSlope(request.landSlope())
                .landAccess(request.landAccess())
                .helpType(request.helpType())
                .startPlan(request.startPlan())
                .priority(request.priority())
                .build();

        return inquiryRepository.save(inquiry);
    }
}
