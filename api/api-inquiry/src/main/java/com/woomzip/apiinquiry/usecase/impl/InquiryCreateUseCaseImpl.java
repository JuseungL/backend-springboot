package com.woomzip.apiinquiry.usecase.impl;

import com.woomzip.apiinquiry.usecase.InquiryCreateUseCase;
import com.woomzip.common.annotation.ApplicationService;
import com.woomzip.domainmysql.inquiry.dto.request.InquiryCreateRequest;
import com.woomzip.domainmysql.inquiry.service.InquiryCommandService;
import lombok.RequiredArgsConstructor;

@ApplicationService
@RequiredArgsConstructor
public class InquiryCreateUseCaseImpl implements InquiryCreateUseCase {
    private final InquiryCommandService inquiryCommandService;
    @Override
    public void createInquiry(InquiryCreateRequest inquiryCreateRequest) {
        inquiryCommandService.createInquiry(inquiryCreateRequest);
    }
}
