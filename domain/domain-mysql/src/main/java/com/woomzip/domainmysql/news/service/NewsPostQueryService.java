package com.woomzip.domainmysql.news.service;

import com.woomzip.common.annotation.DomainService;
import com.woomzip.domainmysql.news.dto.response.NewsPostGetAllResponse;
import com.woomzip.domainmysql.news.dto.response.NewsPostGetResponse;
import com.woomzip.domainmysql.news.entity.NewsPost;
import com.woomzip.domainmysql.news.repository.NewsPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@DomainService
@RequiredArgsConstructor
public class NewsPostQueryService {
    private final NewsPostRepository newsPostRepository;

    @Transactional(readOnly = true)
    public List<NewsPostGetAllResponse> getAllNewsPosts() {
        List<NewsPost> newsPosts = newsPostRepository.findAllByOrderByCreatedDateDesc();
        List<NewsPostGetAllResponse> responseList = newsPosts.stream()
                .map(newsPost -> NewsPostGetAllResponse.from(newsPost))
                .collect(Collectors.toList());
        return responseList;
    }

    @Transactional(readOnly = true)
    public NewsPostGetResponse getNewsPost(Long newsPostId) {
        NewsPost byIdOrThrow = newsPostRepository.findByIdOrThrow(newsPostId);
        return NewsPostGetResponse.from(byIdOrThrow);
    }


}
