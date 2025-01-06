package com.woomzip.domainmysql.inquiry.repository;

import com.woomzip.domainmysql.inquiry.entity.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InquiryRepository extends JpaRepository<Inquiry, Long> {
}
