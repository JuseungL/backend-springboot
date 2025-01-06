package com.woomzip.domainmysql.vendor.repository;

import com.woomzip.domainmysql.vendor.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
