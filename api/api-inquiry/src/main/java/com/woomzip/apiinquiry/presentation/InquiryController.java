package com.woomzip.apiinquiry.presentation;

import com.woomzip.apiinquiry.usecase.InquiryCreateUseCase;
import com.woomzip.apiinquiry.usecase.InquiryGetAllUseCase;
import com.woomzip.common.response.ApplicationResponse;
import com.woomzip.domainmysql.inquiry.dto.request.InquiryCreateRequest;
import com.woomzip.domainmysql.inquiry.dto.response.InquiryResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "문의 관련 API", description = "문의와 관련된 API 명세입니다.")
@RestController
@RequestMapping("/api/v1/inquiries")
@RequiredArgsConstructor
public class InquiryController {
    private final InquiryCreateUseCase inquiryCreateUseCase;
    private final InquiryGetAllUseCase inquiryGetAllUseCase;
    @PostMapping
    @Operation(
            summary = "문의 생성 API",
            description = "문의를 생성하기 위한 API 입니다. 문의를 생성합니다."
    )
    public ApplicationResponse<String> createInquiries(@Valid @RequestBody InquiryCreateRequest inquiryCreateRequests) {
        inquiryCreateUseCase.createInquiry(inquiryCreateRequests);
        return ApplicationResponse.created("문의 등록 성공");
    }

    @GetMapping
    @Operation(
            summary = "문의 전체 조회 API",
            description = "모든 문의사항을 조회할 수 있는 API입니다. 등록된 문의 목록을 반환합니다."
    )
    public ApplicationResponse<List<InquiryResponse>> getAllInquiries() {;
        return ApplicationResponse.ok(inquiryGetAllUseCase.getAllInquiries());
    }
}
