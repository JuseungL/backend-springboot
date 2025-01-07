package com.woomzip.domainmysql.product.service;

import com.woomzip.common.annotation.DomainService;
import com.woomzip.domainmysql.product.dto.request.ProductCreateRequest;
import com.woomzip.domainmysql.product.entity.Product;
import com.woomzip.domainmysql.product.entity.ProductTemplate;
import com.woomzip.domainmysql.product.repository.ProductRepository;
import com.woomzip.domainmysql.product.repository.ProductTemplateRepository;
import com.woomzip.domainmysql.vendor.entity.Vendor;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@DomainService
@RequiredArgsConstructor
public class ProductCommandService {

    private final ProductRepository productRepository;
    private final ProductTemplateRepository productTemplateRepository;

    @Transactional
    public void createProduct(ProductCreateRequest request, Vendor vendor) {
        Product product = ProductCreateRequest.toEntity(request, vendor);
        productRepository.save(product);

        List<ProductTemplate> templates = request.productTemplates().stream()
                .map(templateRequest -> ProductCreateRequest.ProductTemplateCreateRequest.toEntity(templateRequest, product))
                .toList();
        productTemplateRepository.saveAll(templates);
    }

}
