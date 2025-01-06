package com.woomzip.apiinquiry.presentation;

import com.woomzip.apiinquiry.usecase.InquiryCreateUseCase;
import com.woomzip.common.response.ApplicationResponse;
import com.woomzip.domainmysql.inquiry.dto.request.InquiryCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/inquiries")
@RequiredArgsConstructor
public class InquiryController {
    private final InquiryCreateUseCase inquiryCreateUseCase;
    @PostMapping
    public ApplicationResponse<String> createInquiries(@RequestBody InquiryCreateRequest inquiryCreateRequests) {
        inquiryCreateUseCase.createInquiry(inquiryCreateRequests);
        return ApplicationResponse.created("문의 등록 성공");
    }

    // TODO : 문의 조회
}
