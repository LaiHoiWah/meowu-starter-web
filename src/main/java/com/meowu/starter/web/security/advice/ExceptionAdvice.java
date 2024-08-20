package com.meowu.starter.web.security.advice;

import com.meowu.starter.web.security.constant.Response;
import com.meowu.starter.web.security.constant.ResponseCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice{

    private final static Logger LOG = LoggerFactory.getLogger(ExceptionAdvice.class);

    @ExceptionHandler(value = {
        Exception.class,
        RuntimeException.class
    })
    public <T> Response<T> exceptionHandler(Exception e){
        // log
        LOG.error(e.getMessage(), e);

        // return error response
        return new Response<>(ResponseCode.FAILURE, e.getMessage());
    }
}
