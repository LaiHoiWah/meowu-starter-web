package com.meowu.starter.web.security.holder;

import java.util.Map;

public class ThreadContextHolder{

    private static final ThreadLocal<Map<String, Object>> LOCAL = new ThreadLocal<>();
    private static final InheritableThreadLocal<Map<String, Object>> INHERITABLE = new InheritableThreadLocal<>();

    public static void put(Map<String, Object> map, boolean inherit){
        if(inherit){
            INHERITABLE.set(map);
        }else{
            LOCAL.set(map);
        }
    }

    public static void reset(){
        LOCAL.remove();
        INHERITABLE.remove();
    }
}
