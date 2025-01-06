package com.woomzip.domainmysql.product.repository;

import com.woomzip.common.exception.apivendor.VendorErrorCode;
import com.woomzip.common.exception.apivendor.VendorException;
import com.woomzip.domainmysql.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

import static com.woomzip.common.exception.apivendor.VendorErrorCode.PRODUCT_NOT_FOUND;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findById(Long productId);
    default Product findByIdOrThrow(Long productId) {
        return findById(productId).orElseThrow(() -> new VendorException(PRODUCT_NOT_FOUND));
    }
}

