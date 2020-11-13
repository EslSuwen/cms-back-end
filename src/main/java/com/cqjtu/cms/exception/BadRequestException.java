package com.cqjtu.cms.exception;

import org.springframework.http.HttpStatus;

/**
 * @author johnniang
 * @classname BadRequestException
 * @description Bad request exception.
 * @date 11/23/18
 */
public class BadRequestException extends BaseApiException {
    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
