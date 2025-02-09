package com.woomzip.apivendor.usecase.news.impl;

import com.woomzip.apivendor.usecase.news.NewsPostGetUseCase;
import com.woomzip.common.annotation.ApplicationService;
import com.woomzip.domainmysql.news.dto.response.NewsPostGetResponse;
import com.woomzip.domainmysql.news.service.NewsPostQueryService;
import lombok.RequiredArgsConstructor;

@ApplicationService
@RequiredArgsConstructor
public class NewsPostGetUseCaseImpl implements NewsPostGetUseCase {
    private final NewsPostQueryService newsPostQueryService;
    @Override
    public NewsPostGetResponse getNewsPost(Long newsPostId) {
        return newsPostQueryService.getNewsPost(newsPostId);
    }
}
