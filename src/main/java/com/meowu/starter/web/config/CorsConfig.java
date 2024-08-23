package com.meowu.starter.web.config;

import com.google.common.collect.Lists;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
public class CorsConfig{

    @ConditionalOnProperty(name = "meowu.web.cors", havingValue = "true")
    @Bean
    public CorsFilter corsFilter(){
        List<String> all = Lists.newArrayList(CorsConfiguration.ALL);
        // cors config
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedMethods(Lists.newArrayList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        config.setAllowCredentials(true);
        config.setAllowedHeaders(all);
        config.setAllowedOrigins(all);
        config.setAllowedOriginPatterns(all);
        config.setExposedHeaders(all);

        // set url mapping
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/api/**", config);

        return new CorsFilter(source);
    }
}
