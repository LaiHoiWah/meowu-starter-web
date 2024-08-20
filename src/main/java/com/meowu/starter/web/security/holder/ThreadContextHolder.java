package com.meowu.starter.web.security.holder;

public class ThreadContextHolder{

    private static final ThreadLocal<Object> LOCAL = new ThreadLocal<Object>();

    public static void set(Object o){
        LOCAL.set(o);
    }

    public static Object get(){
        return LOCAL.get();
    }

    public static void reset(){
        LOCAL.remove();
    }
}
