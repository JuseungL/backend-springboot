package com.woomzip.domainmysql.product.service;

import com.woomzip.common.annotation.DomainService;
import com.woomzip.domainmysql.product.repository.ProductRepository;
import com.woomzip.domainmysql.product.repository.ProductTemplateRepository;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class ProductQueryService {
    private final ProductRepository productRepository;
    private final ProductTemplateRepository productTemplateRepository;


}
