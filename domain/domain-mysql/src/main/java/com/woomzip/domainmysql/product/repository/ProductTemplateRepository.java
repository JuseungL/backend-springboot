package com.woomzip.domainmysql.product.repository;

import com.woomzip.domainmysql.product.entity.ProductTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductTemplateRepository extends JpaRepository<ProductTemplate, Long> {
    List<ProductTemplate> findByProductId(Long productId);
}
