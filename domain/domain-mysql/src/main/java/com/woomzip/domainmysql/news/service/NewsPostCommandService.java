package com.woomzip.domainmysql.news.service;

import com.woomzip.common.annotation.DomainService;
import com.woomzip.domainmysql.news.dto.request.NewsPostCreateRequest;
import com.woomzip.domainmysql.news.entity.NewsPost;
import com.woomzip.domainmysql.news.repository.NewsPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@DomainService
@RequiredArgsConstructor
public class NewsPostCommandService {
    private final NewsPostRepository newsPostRepository;

    @Transactional
    public void createProduct(NewsPostCreateRequest request) {
        NewsPost newsPost = NewsPostCreateRequest.toEntity(request);
        newsPostRepository.save(newsPost);
    }
}
