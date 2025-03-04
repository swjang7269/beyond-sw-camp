package com.ohgiraffers.section03.properties.subsection02.i18n;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class ContextConfiguration {
    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource =
                new ReloadableResourceBundleMessageSource();

        /* 설명. 다국어 메시지를 읽어올 설정파일(properties)의 이름과 경로 설명 */
        messageSource.setBasename("section03/properties/subsection02/i18n/message");

        /* 설명. 불러온 메시지를 설정한 해당 시간동안 캐싱한다. */
        messageSource.setCacheMillis(1);

        /* 설명. 기본 인코딩 셋을 설정할 수 있다. */
        messageSource.setDefaultEncoding("UTF-8");

        return messageSource;
    }
}
