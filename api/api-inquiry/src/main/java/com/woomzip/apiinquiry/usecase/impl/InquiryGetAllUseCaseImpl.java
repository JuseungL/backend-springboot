package com.woomzip.apiinquiry.usecase;

import com.woomzip.common.annotation.ApplicationService;
import com.woomzip.domainmysql.inquiry.dto.response.InquiryResponse;
import com.woomzip.domainmysql.inquiry.entity.Inquiry;
import com.woomzip.domainmysql.inquiry.repository.InquiryRepository;
import com.woomzip.domainmysql.inquiry.service.InquiryQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationService
@RequiredArgsConstructor
public class InquiryGetAllUseCaseImpl implements InquiryGetAllUseCase {

    private final InquiryQueryService inquiryQueryService;

    @Override
    public List<InquiryResponse> getAllInquiries() {
        List<Inquiry> inquiries = inquiryQueryService.getAllInquiries();
        return inquiries.stream()
                .map(InquiryResponse::from)
                .collect(Collectors.toList());
    }
}