package com.woomzip.apiproduct.usecase;

import com.woomzip.domainmysql.product.dto.request.ProductCreateRequest;
import com.woomzip.domainmysql.product.dto.response.ProductGetResponse;

public interface ProductGetUseCase {
    ProductGetResponse getProduct(Long productId);
}
