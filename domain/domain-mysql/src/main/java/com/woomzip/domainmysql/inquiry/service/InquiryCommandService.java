package com.woomzip.domainmysql.inquiry.service;

import com.woomzip.common.annotation.DomainService;
import com.woomzip.domainmysql.inquiry.dto.request.InquiryCreateRequest;
import com.woomzip.domainmysql.inquiry.entity.Inquiry;
import com.woomzip.domainmysql.inquiry.repository.InquiryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@DomainService
@RequiredArgsConstructor
public class InquiryCommandService {
    private final InquiryRepository inquiryRepository;

    @Transactional
    public Inquiry createInquiry(InquiryCreateRequest inquiryCreateRequest) {
        return inquiryRepository.save(InquiryCreateRequest.toEntity(inquiryCreateRequest));
    }
}