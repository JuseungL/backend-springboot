package com.woomzip.apiproduct.usecase;

import com.woomzip.domainmysql.inquiry.dto.request.InquiryCreateRequest;
import com.woomzip.domainmysql.product.dto.request.ProductCreateRequest;

public interface ProductCreateUseCase {
    void createProduct(ProductCreateRequest productCreateRequest);

}
