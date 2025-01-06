package com.woomzip.apiinquiry.usecase;

import com.woomzip.domainmysql.inquiry.dto.response.InquiryResponse;

import java.util.List;

public interface InquiryGetAllUseCase {
    List<InquiryResponse> getAllInquiries();
}