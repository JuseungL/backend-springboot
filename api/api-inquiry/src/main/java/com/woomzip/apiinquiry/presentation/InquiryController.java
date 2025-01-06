package com.woomzip.apiinquiry.presentation;

import com.woomzip.apiinquiry.usecase.InquiryCreateUseCase;
import com.woomzip.apiinquiry.usecase.InquiryGetAllUseCase;
import com.woomzip.common.response.ApplicationResponse;
import com.woomzip.domainmysql.inquiry.dto.request.InquiryCreateRequest;
import com.woomzip.domainmysql.inquiry.dto.response.InquiryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inquiries")
@RequiredArgsConstructor
public class InquiryController {
    private final InquiryCreateUseCase inquiryCreateUseCase;
    private final InquiryGetAllUseCase inquiryGetAllUseCase;
    @PostMapping
    public ApplicationResponse<String> createInquiries(@RequestBody InquiryCreateRequest inquiryCreateRequests) {
        inquiryCreateUseCase.createInquiry(inquiryCreateRequests);
        return ApplicationResponse.created("문의 등록 성공");
    }

    // TODO : 문의 조회
    @GetMapping
    public ApplicationResponse<List<InquiryResponse>> getAllInquiries() {;
        return ApplicationResponse.ok(inquiryGetAllUseCase.getAllInquiries());
    }
}
