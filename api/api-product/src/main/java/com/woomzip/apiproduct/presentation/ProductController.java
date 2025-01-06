package com.woomzip.apiproduct.presentation;

import com.woomzip.apiproduct.usecase.ProductCreateUseCase;
import com.woomzip.common.response.ApplicationResponse;
import com.woomzip.domainmysql.product.dto.request.ProductCreateRequest;
import com.woomzip.domainmysql.product.entity.Product;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductCreateUseCase productCreateUseCase;

    // 상품 생성 (POST)
    @PostMapping
    public ApplicationResponse<String> createProduct(@Valid @RequestBody ProductCreateRequest productCreateRequest) {
        productCreateUseCase.createProduct(productCreateRequest);
        return ApplicationResponse.created("제품 등록 성공");
    }

//    // 상품 조회 (전체) (GET)
//    @GetMapping
//    public ResponseEntity<List<Product>> getAllProducts() {
//        List<Product> products = productService.getAllProducts();
//        return new ResponseEntity<>(products, HttpStatus.OK);
//    }
//
//    // 상품 조회 (ID로) (GET)
//    @GetMapping("/{id}")
//    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
//        Optional<Product> product = productService.getProductById(id);
//        return product.map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
//    }
}
