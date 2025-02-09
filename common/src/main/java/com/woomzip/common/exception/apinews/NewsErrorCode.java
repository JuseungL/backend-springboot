package com.woomzip.common.exception.apinews;

import com.woomzip.common.exception.BaseErrorCode;
import com.woomzip.common.response.ApplicationResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum NewsErrorCode implements BaseErrorCode {
    NEWS_POST_NOT_FOUND("뉴스 게시글을 찾을 수 없습니다.", 3001, HttpStatus.NOT_FOUND),
    ;

    private final String message;
    private final int errorCode;
    private final HttpStatus httpStatus;

    @Override
    public ApplicationResponse<String> toResponseEntity() {
        return ApplicationResponse.server(message);
    }
}