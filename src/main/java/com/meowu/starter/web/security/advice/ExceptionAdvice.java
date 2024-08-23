package com.meowu.starter.web.security.advice;

import com.meowu.starter.commons.security.constants.ResponseCode;
import com.meowu.starter.commons.security.domain.Response;
import com.meowu.starter.commons.security.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice{

    private final static Logger LOG = LoggerFactory.getLogger(ExceptionAdvice.class);

    @ExceptionHandler(value = {
        Exception.class, RuntimeException.class
    })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @SuppressWarnings("rawtypes")
    public Response exceptionHandler(Exception e){
        // log
        LOG.error(e.getMessage(), e);

        // return error response
        return new Response(ResponseCode.FAILURE, e.getMessage());
    }

    @ExceptionHandler(value = {BusinessException.class})
    @ResponseStatus(HttpStatus.OK)
    @SuppressWarnings("rawtypes")
    public Response businessExceptionHandler(BusinessException e){
        // log
        LOG.error(e.getMessage(), e);

        // return error response
        return new Response(e.getCode(), e.getMessage());
    }
}
