package com.ohgiraffers.exceptionhandler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

@Configuration
public class RootConfiguration {
    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();

        // exception 타입에 따라 어느 페이지로 처리할지 매핑
        /* 설명. 예외 타입과 처리할 페이지 설정 */
        Properties props = new Properties();
        props.setProperty("java.lang.NullPointerException", "error/nullPointer");
        // 원래는 풀네임 but 안겹치는 유일한 이름이면 생략 가능
//        props.setProperty("com.ohgiraffers.exceptionhandler.MemberRegistException",)
        props.setProperty("MemberRegistException", "error/memberRegist");

        /* 설명. 전체 예외 관련되어 설정하기 */
        /* 설명. 1. 예외에 따른 페이지 설정한 값 활용 */
        exceptionResolver.setExceptionMappings(props);

        /* 설명. 2. 그 외 나머지 예외에 대한 default 페이지 설정 */
        exceptionResolver.setDefaultErrorView("error/default");

        /* 설명. 3. 예외 객체를 담기 위한 Attribute key값 설정(화면에서 예외 메시지 확인할 때 사용할 key값) */
        exceptionResolver.setExceptionAttribute("exceptionMessage");

        return exceptionResolver;
    }
}
