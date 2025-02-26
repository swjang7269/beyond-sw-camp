package com.ohgiraffers.section02.uses;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/member/*")
public class EncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;

        // 인코딩 설정
        /* 설명.
         *  톰캣 10버전 이전에는 post 요청시 인코딩 설정을 하지 않으면 한글이 깨지곤 했다.
         *  10버전 이후의 톰캣에서는 굳이 하지 않아도 동작하지만 이전 버전의 경우 인코딩 설정이 필요하다.
         *  또한 다른 인코딩 설정으로 바꿀 때도 해당 방식의 필터로 활용할 수 있다.
         */
        if("POST".equals(httpRequest.getMethod())) {
            httpRequest.setCharacterEncoding("UTF-8");
        }

        filterChain.doFilter(httpRequest, servletResponse);
    }
}
