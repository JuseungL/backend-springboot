package com.woomzip.domainmysql.inquiry.service;

import com.woomzip.common.annotation.DomainService;
import com.woomzip.domainmysql.inquiry.entity.Inquiry;
import com.woomzip.domainmysql.inquiry.repository.InquiryRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainService
@RequiredArgsConstructor
public class InquiryQueryService {

    private final InquiryRepository inquiryRepository;

    // 모든 문의 조회
    public List<Inquiry> getAllInquiries() {
        return inquiryRepository.findAll();
    }
}