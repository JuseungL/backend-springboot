package com.woomzip.apivendor.presentation;

import com.woomzip.apivendor.usecase.news.NewsPostCreateUseCase;
import com.woomzip.apivendor.usecase.news.NewsPostGetAllUseCase;
import com.woomzip.apivendor.usecase.news.NewsPostGetUseCase;
import com.woomzip.common.response.ApplicationResponse;
import com.woomzip.domainmysql.news.dto.request.NewsPostCreateRequest;
import com.woomzip.domainmysql.news.dto.response.NewsPostGetAllResponse;
import com.woomzip.domainmysql.news.dto.response.NewsPostGetResponse;
import com.woomzip.domainmysql.vendor.dto.request.VendorCreateRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "뉴스 게시글 관련 API", description = "뉴스 게시글과 관련된 API 명세입니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/news")
public class NewsPostController {

    private final NewsPostCreateUseCase newsPostCreateUseCase;
    private final NewsPostGetAllUseCase newsPostGetAllUseCase;
    private final NewsPostGetUseCase newsPostGetUseCase;

    @PostMapping
    @Operation(
            summary = "뉴스 게시글 등록 API",
            description = "새로운뉴스 게시글을 등록합니다."
    )
    public ApplicationResponse<String> createVendor(
            @Valid @RequestBody NewsPostCreateRequest newsPostCreateRequest
    ) {
        newsPostCreateUseCase.createNewsPost(newsPostCreateRequest);
        return ApplicationResponse.created("뉴스 게시글 등록 성공");
    }
    @GetMapping
    @Operation(
            summary = "뉴스 게시글 목록 조회 API",
            description = "모든 뉴스 게시글을 조회합니다."
    )
    public ApplicationResponse<List<NewsPostGetAllResponse>> getAllNewsPosts() {
        List<NewsPostGetAllResponse> response = newsPostGetAllUseCase.getAllNewsPost();
        return ApplicationResponse.ok(response,"뉴스 게시글 리스트 조회 성공");
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "뉴스 게시글 상세 조회 API",
            description = "특정 뉴스 게시글을 ID로 조회합니다."
    )
    public ApplicationResponse<NewsPostGetResponse> getNewsPostById(@PathVariable Long id) {
        NewsPostGetResponse response = newsPostGetUseCase.getNewsPost(id);
        return ApplicationResponse.ok(response, "뉴스 게시글 상세 조회 성공");
    }
}
