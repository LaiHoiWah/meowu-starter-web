package com.meowu.starter.web.config;

import com.meowu.commons.utils.GsonUtils;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import java.nio.charset.StandardCharsets;

@Configuration
public class HttpMessageConverterConfig{

    @ConditionalOnProperty(name = "meowu.web.converter", havingValue = "gson")
    @Bean
    public HttpMessageConverters gsonConverters(){
        // gson convert
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        converter.setDefaultCharset(StandardCharsets.UTF_8);
        converter.setGson(GsonUtils.getGson());

        return new HttpMessageConverters(converter);
    }

    @ConditionalOnProperty(name = "meowu.web.converter", havingValue = "string")
    @Bean
    public HttpMessageConverters stringConverters(){
        // string convert
        StringHttpMessageConverter converter = new StringHttpMessageConverter();
        converter.setDefaultCharset(StandardCharsets.UTF_8);

        return new HttpMessageConverters(converter);
    }
}
