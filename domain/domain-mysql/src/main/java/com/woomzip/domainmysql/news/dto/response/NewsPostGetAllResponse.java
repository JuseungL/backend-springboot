package com.woomzip.domainmysql.news.dto.response;

import com.woomzip.common.utils.TimeUtils;
import com.woomzip.domainmysql.news.entity.NewsPost;

public record NewsPostGetAllResponse(
        Long id,
        String title,
        String postMainImage,
        String postType,
        String createdDate
) {

    public static NewsPostGetAllResponse from(NewsPost newsPost) {
        return new NewsPostGetAllResponse(
                newsPost.getId(),
                newsPost.getPostTitle(),
                newsPost.getPostMainImageUrl(),
                newsPost.getPostType().getDescription(),
                TimeUtils.refineToDateTime(newsPost.getCreatedDate())
        );
    }
}