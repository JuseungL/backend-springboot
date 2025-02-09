package com.woomzip.common.exception.apinews;

import com.woomzip.common.exception.BaseErrorCode;
import com.woomzip.common.exception.CustomException;

public class NewsException  extends CustomException {
    public NewsException(BaseErrorCode baseErrorCode) {super(baseErrorCode);}
}