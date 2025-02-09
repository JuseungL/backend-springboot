package com.woomzip.domainmysql.news.dto.response;

import com.woomzip.common.utils.TimeUtils;
import com.woomzip.domainmysql.news.entity.NewsPost;

public record NewsPostGetResponse(
        Long id,
        String title,
        String postMainImage,
        String postType,
        String postContent,
        String createdDate
) {

    public static NewsPostGetResponse from(NewsPost newsPost) {
        return new NewsPostGetResponse(
                newsPost.getId(),
                newsPost.getPostTitle(),
                newsPost.getPostMainImageUrl(),
                newsPost.getPostType().getDescription(),
                newsPost.getPostContent(),
                TimeUtils.refineToDateTime(newsPost.getCreatedDate())
        );
    }
}
