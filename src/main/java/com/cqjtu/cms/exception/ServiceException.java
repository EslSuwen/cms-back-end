package com.cqjtu.cms.exception;

import org.springframework.http.HttpStatus;

/**
 * @author johnniang
 * @classname ServiceException
 * @description Service exception
 * @date 11/23/18
 */
public class ServiceException extends BaseApiException {

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
