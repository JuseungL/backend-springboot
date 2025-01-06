package com.woomzip.domainmysql.product.repository;

import com.woomzip.domainmysql.product.entity.ProductTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTemplateRepository extends JpaRepository<ProductTemplate, Long> {
}
