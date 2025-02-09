package com.woomzip.domainmysql.news.repository;

import com.woomzip.common.exception.apinews.NewsException;
import com.woomzip.domainmysql.news.entity.NewsPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

import static com.woomzip.common.exception.apinews.NewsErrorCode.NEWS_POST_NOT_FOUND;

public interface NewsPostRepository extends JpaRepository<NewsPost, Long> {
    List<NewsPost> findAllByOrderByCreatedDateDesc();

    Optional<NewsPost> findById(Long newsPostId);

    default NewsPost findByIdOrThrow(Long newsPostId) {
        return findById(newsPostId).orElseThrow(() -> new NewsException(NEWS_POST_NOT_FOUND));
    }
}