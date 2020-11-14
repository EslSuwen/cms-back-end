package com.cqjtu.cms.exception;

import org.springframework.http.HttpStatus;

/**
 * BeanUtilsException Occur when BeanUtils throws.
 *
 * @author johnniang
 * @date 11/22/18
 */
public class BeanUtilsException extends BaseApiException {
  public BeanUtilsException(String message) {
    super(message);
  }

  public BeanUtilsException(String message, Throwable cause) {
    super(message, cause);
  }

  @Override
  public HttpStatus getStatus() {
    return HttpStatus.INTERNAL_SERVER_ERROR;
  }
}
