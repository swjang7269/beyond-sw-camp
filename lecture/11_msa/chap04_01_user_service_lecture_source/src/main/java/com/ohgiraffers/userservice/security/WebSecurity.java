package com.ohgiraffers.userservice.security;

import jakarta.servlet.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.Collections;

/* 설명. WebSecurityConfigurerAdapter를 상속 받거나 @EnableeWebSecurity를 쓰는 예제는 옛날 방식 */
@Configuration
public class WebSecurity {
    private JwtUtil jwtutil;

    private JwtAuthenticationProvider jwtAuthenticationProvider;

    @Autowired
    public WebSecurity(JwtAuthenticationProvider jwtAuthenticationProvider, JwtUtil jwtutil) {
        this.jwtAuthenticationProvider = jwtAuthenticationProvider;
        this.jwtutil = jwtutil;
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(Collections.singletonList(jwtAuthenticationProvider));
    }

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());  // csrf 토큰을 사용하지 않겠다.

        // 화이트 라벨 -> 허용된 것만 가능 나머진 다 안됨 (참고. 블랙 라벨 -> 금지한 것만 안됨 나머진 다 됨)
        /* 설명. 허용되는 경로 및 권한 설정 */
        http.authorizeHttpRequests(authz ->
//                        authz.requestMatchers(new AntPathRequestMatcher("/users/**")).permitAll()
//                        .anyRequest().authenticated()
                authz.requestMatchers(new AntPathRequestMatcher("/health", "GET")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/users/**", "POST")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/test", "GET")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/users/**", "GET")).hasRole("ENTERPRISE")
                )
                .authenticationManager(authenticationManager())
                /* 설명. Session을 쓰지 않고 Jwt토큰 방식으로 LocalThread에 저장하겠다는 설정 */
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.addFilter(getAuthenticationFilter(authenticationManager()));

        /* 설명. 로그인 이후 사용자가 들고 온(request header에 발급받은 bearer 토큰을 들고옴) 토큰을 검증하기 위한 필터 */
        http.addFilter(new JwtFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    /* 설명. Filter는 jakarta.servlet으로 import */
    // 필터를 등록하는 과정
    private Filter getAuthenticationFilter(AuthenticationManager authenticationManager) {
        return new AuthenticationFilter(authenticationManager);
    }
}
