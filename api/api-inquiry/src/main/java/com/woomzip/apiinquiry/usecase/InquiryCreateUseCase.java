package com.woomzip.apiinquiry.usecase;

import com.woomzip.domainmysql.inquiry.dto.request.InquiryCreateRequest;

public interface InquiryCreateUseCase {
    void createInquiry(InquiryCreateRequest inquiryCreateRequest);
}
