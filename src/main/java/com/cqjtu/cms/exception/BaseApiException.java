package com.cqjtu.cms.exception;

import org.springframework.http.HttpStatus;

/**
 * @author johnniang
 * @classname BaseApiException
 * @description Global exception
 * @date 11/22/18
 */
public abstract class BaseApiException extends RuntimeException {

    BaseApiException(String message) {
        super(message);
    }

    BaseApiException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * get exception status
     *
     * @return status should be returned.
     */
    public abstract HttpStatus getStatus();
}
