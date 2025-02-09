package com.woomzip.apivendor.usecase.news.impl;

import com.woomzip.apivendor.usecase.news.NewsPostCreateUseCase;
import com.woomzip.common.annotation.ApplicationService;
import com.woomzip.domainmysql.news.dto.request.NewsPostCreateRequest;
import com.woomzip.domainmysql.news.service.NewsPostCommandService;
import lombok.RequiredArgsConstructor;

@ApplicationService
@RequiredArgsConstructor
public class NewsPostCreateUseCaseImpl implements NewsPostCreateUseCase {
    private final NewsPostCommandService newsPostCommandService;
    @Override
    public void createNewsPost(NewsPostCreateRequest newsPostCreateRequest) {
        newsPostCommandService.createProduct(newsPostCreateRequest);
    }
}
