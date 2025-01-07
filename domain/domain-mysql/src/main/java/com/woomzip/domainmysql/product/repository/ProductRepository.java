package com.woomzip.domainmysql.product.repository;

import com.woomzip.common.exception.apiproduct.ProductException;
import com.woomzip.domainmysql.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import static com.woomzip.common.exception.apiproduct.ProductErrorCode.PRODUCT_NOT_FOUND;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findById(Long productId);
    default Product findByIdOrThrow(Long productId) {
        return findById(productId).orElseThrow(() -> new ProductException(PRODUCT_NOT_FOUND));
    }
}

