package com.kaishengit.exception;

import com.kaishengit.exception.ServiceException;

/**
 * 认证异常
 * Created by fankay on 2017/7/19.
 */
public class AuthenticationException extends ServiceException {

    public AuthenticationException(){}
    public AuthenticationException(String message) {
        super(message);
    }
    public AuthenticationException(String message,Throwable th) {
        super(message,th);
    }

}
