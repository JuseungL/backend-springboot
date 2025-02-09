package com.woomzip.domainmysql.news.repository;

import com.woomzip.common.exception.apiproduct.ProductException;
import com.woomzip.domainmysql.news.entity.NewsPost;
import com.woomzip.domainmysql.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

import static com.woomzip.common.exception.apiproduct.ProductErrorCode.PRODUCT_NOT_FOUND;

public interface NewsPostRepository extends JpaRepository<NewsPost, Long> {
    List<NewsPost> findAllByOrderByCreatedDateDesc();

    Optional<NewsPost> findById(Long newsPostId);

    default NewsPost findByIdOrThrow(Long newsPostId) {
        return findById(newsPostId).orElseThrow(() -> new ProductException(PRODUCT_NOT_FOUND));
    }
}
