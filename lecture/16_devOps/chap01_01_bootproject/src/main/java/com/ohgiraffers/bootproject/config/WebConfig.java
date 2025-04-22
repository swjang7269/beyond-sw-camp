package com.ohgiraffers.bootproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
//                .allowedOrigins("http://localhost:5173")
//                .allowedOrigins("http://localhost:8011")    // 프론트는 컨테이너포트 8011을 통해 요청이 올것이다.
                .allowedOrigins("http://localhost:30000")   // 프론트의 워커 노드는 30000번으로 띄워질 것이다.
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
