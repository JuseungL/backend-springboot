package com.woomzip.apivendor.usecase.news;

import com.woomzip.domainmysql.news.dto.response.NewsPostGetResponse;

public interface NewsPostGetUseCase {
    NewsPostGetResponse getNewsPost(Long newsPostId);
}
