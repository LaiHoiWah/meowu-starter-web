package com.meowu.starter.web.domain;

import com.meowu.starter.commons.domain.Create;
import com.meowu.starter.commons.domain.Identity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AlsLogger implements Identity<Long>, Create{

    private Long id;
    private String correlationId;
    private String application;
    private String hostName;
    private String className;
    private String input;
    private String output;
    private String content;
    private String level;
    private Date createTime;
}
