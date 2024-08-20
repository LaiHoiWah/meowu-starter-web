package com.meowu.starter.web.security.constant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response<T>{

    private T data;
    private String message;
    private Integer code;

    public Response(){

    }

    public Response(Integer code){
        this.code = code;
    }

    public Response(Integer code, String message){
        this.code    = code;
        this.message = message;
    }

    public Response(T data, Integer code, String message){
        this.data    = data;
        this.code    = code;
        this.message = message;
    }
}
