package com.woomzip.common.exception.apiproduct;

import com.woomzip.common.exception.BaseErrorCode;
import com.woomzip.common.exception.CustomException;

public class ProductException extends CustomException {
    public ProductException(BaseErrorCode baseErrorCode) {super(baseErrorCode);}
}