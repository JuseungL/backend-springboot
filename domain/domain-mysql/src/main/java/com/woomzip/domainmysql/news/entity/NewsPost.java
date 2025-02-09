package com.woomzip.domainmysql.news.entity;

import com.woomzip.domainmysql.auditing.BaseEntity;
import com.woomzip.domainmysql.news.enums.NewsPostType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NewsPost extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(name = "post_title", nullable = false, length = 50)
    private String postTitle; // 뉴스 제목

    @Column(name = "post_main_image_url", nullable = false, length = 255)
    private String postMainImageUrl; // 뉴스 제목

    @Column(name = "post_content", nullable = false, columnDefinition = "TEXT")
    private String postContent; // 뉴스 내용

    @Column(name = "post_type", nullable = false, length = 15)
    @Enumerated(EnumType.STRING)
    private NewsPostType postType;

    @Builder
    public NewsPost(String postTitle, String postMainImageUrl, String postContent, NewsPostType postType) {
        this.postTitle = postTitle;
        this.postMainImageUrl = postMainImageUrl;
        this.postContent = postContent;
        this.postType = postType;
    }
}
