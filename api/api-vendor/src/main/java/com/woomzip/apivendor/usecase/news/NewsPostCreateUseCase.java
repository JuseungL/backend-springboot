package com.woomzip.apivendor.usecase.news;

import com.woomzip.domainmysql.news.dto.request.NewsPostCreateRequest;
import com.woomzip.domainmysql.vendor.dto.request.VendorCreateRequest;

public interface NewsPostCreateUseCase {
    void createNewsPost(NewsPostCreateRequest newsPostCreateRequest);
}
