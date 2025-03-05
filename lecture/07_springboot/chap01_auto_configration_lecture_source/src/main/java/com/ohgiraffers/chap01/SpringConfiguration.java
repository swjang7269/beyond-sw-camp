package com.ohgiraffers.chap01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {
    @Value("${test.value}") // .properties가 .yml보다 강력(우선순위)
    public String testValue;

    @Value("${test.age}")
    public int testAge;

    /* 설명. @Value는 시스템 환경변수도 불러올 수 있다. */
    @Value("${username}")   // 사용자 이름(컴퓨터 명)
    public String userName;

    @Bean
    public Object propertReadTest() {
        System.out.println("testValue = " + testValue);
        System.out.println("age = " + testAge);
        System.out.println("userName = " + userName);

        return new Object();
    }
}
