package com.woomzip.apivendor.usecase.news;

import com.woomzip.domainmysql.news.dto.response.NewsPostGetAllResponse;

import java.util.List;

public interface NewsPostGetAllUseCase {
    List<NewsPostGetAllResponse> getAllNewsPost();
}
