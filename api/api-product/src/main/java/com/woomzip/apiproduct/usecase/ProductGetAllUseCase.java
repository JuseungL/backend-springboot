package com.woomzip.apiproduct.usecase;

import com.woomzip.domainmysql.product.dto.request.ProductCreateRequest;
import com.woomzip.domainmysql.product.dto.response.ProductGetAllResponse;
import com.woomzip.domainmysql.product.dto.response.ProductGetResponse;

import java.util.List;

public interface ProductGetAllUseCase {
    List<ProductGetAllResponse> getAllProducts();
}
