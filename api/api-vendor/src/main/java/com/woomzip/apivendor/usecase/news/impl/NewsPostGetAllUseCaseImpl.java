package com.woomzip.apivendor.usecase.news.impl;

import com.woomzip.apivendor.usecase.news.NewsPostGetAllUseCase;
import com.woomzip.common.annotation.ApplicationService;
import com.woomzip.domainmysql.news.dto.response.NewsPostGetAllResponse;
import com.woomzip.domainmysql.news.service.NewsPostQueryService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@ApplicationService
@RequiredArgsConstructor
public class NewsPostGetAllUseCaseImpl implements NewsPostGetAllUseCase {
    private final NewsPostQueryService newsPostQueryService;
    @Override
    public List<NewsPostGetAllResponse> getAllNewsPost() {
        return newsPostQueryService.getAllNewsPosts();
    }
}
