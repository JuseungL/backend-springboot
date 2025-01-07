package com.woomzip.apiproduct.presentation;

import com.woomzip.apiproduct.usecase.ProductCreateUseCase;
import com.woomzip.apiproduct.usecase.ProductGetAllUseCase;
import com.woomzip.apiproduct.usecase.ProductGetUseCase;
import com.woomzip.common.response.ApplicationResponse;
import com.woomzip.domainmysql.product.dto.request.ProductCreateRequest;
import com.woomzip.domainmysql.product.dto.response.ProductGetAllResponse;
import com.woomzip.domainmysql.product.dto.response.ProductGetResponse;
import com.woomzip.domainmysql.product.entity.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "제품 관련 API", description = "제품과 관련된 API 명세입니다.")
@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductCreateUseCase productCreateUseCase;
    private final ProductGetAllUseCase productGetAllUseCase;
    private final ProductGetUseCase productGetUseCase;

    // 상품 생성 (POST)
    @PostMapping
    @Operation(
            summary = "제품 생성 API",
            description = "제품을 생성하기 위한 API 입니다. 제품을 생성합니다."
    )
    public ApplicationResponse<String> createProduct(
            @Valid @RequestBody ProductCreateRequest productCreateRequest
    ) {
        productCreateUseCase.createProduct(productCreateRequest);
        return ApplicationResponse.created("제품 등록 성공");
    }

    @GetMapping
    @Operation(
            summary = "제품 전체 조회 API",
            description = "제품 리스트를 조회할 수 있는 API입니다. 등록된 제품 목록을 반환합니다."
    )
    public ApplicationResponse<List<ProductGetAllResponse>> getAllProducts() {
        return ApplicationResponse.ok(productGetAllUseCase.getAllProducts());
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "특정 제품 조회 API",
            description = "특정 제품을 조회할 수 있는 API입니다. 등록된 제품 상세 정보를 id 기반으로 조회 후 반환합니다."
    )
    public ApplicationResponse<ProductGetResponse> getProductById(
            @Parameter(
                    name = "id",
                    description = "조회할 제품의 ID(식별자)",
                    required = true,
                    example = "1",
                    in = ParameterIn.PATH // 명시적으로 경로 변수임을 지정
            ) @PathVariable Long id) {
        return ApplicationResponse.ok(productGetUseCase.getProduct(id));
    }
}
