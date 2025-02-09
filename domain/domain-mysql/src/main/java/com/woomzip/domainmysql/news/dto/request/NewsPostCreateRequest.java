package com.woomzip.domainmysql.news.dto.request;

import com.woomzip.domainmysql.news.entity.NewsPost;
import com.woomzip.domainmysql.news.enums.NewsPostType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Schema(description = "뉴스 게시물 생성 요청 DTO")
public record NewsPostCreateRequest(
        @Schema(description = "뉴스 제목", example = "뉴스 제목 예시", required = true)
        @NotNull(message = "뉴스 제목은 필수입니다.")
        @Size(max = 50, message = "뉴스 제목은 최대 50자까지 입력 가능합니다.")
        String postTitle,

        @Schema(description = "뉴스 대표 이미지 URL", example = "https://image1.jpg", required = true)
        @NotNull(message = "뉴스 대표 이미지는 필수입니다.")
        @Size(max = 255, message = "뉴스 대표 이미지 URL은 최대 255자까지 입력 가능합니다.")
        String postMainImageUrl,

        @Schema(description = "뉴스 내용", example = "뉴스 내용이 여기에 들어갑니다.", required = true)
        @NotNull(message = "뉴스 내용은 필수입니다.")
        String postContent,

        @Schema(description = "뉴스 유형", example = "NEWS", required = true)
        @NotNull(message = "뉴스 유형은 필수입니다.")
        NewsPostType postType
) {
    public static NewsPost toEntity(NewsPostCreateRequest request) {
        return new NewsPost(
                request.postTitle(),
                request.postMainImageUrl(),
                request.postContent(),
                request.postType()
        );
    }
}
