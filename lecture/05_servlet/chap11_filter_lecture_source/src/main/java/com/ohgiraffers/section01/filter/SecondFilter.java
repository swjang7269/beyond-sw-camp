package com.ohgiraffers.section01.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

// 순수 서블릿에서 어노테이션 방식으로는 필터 적용 순서를 임의로 수정할 수 없다.
//@WebFilter(filterName = "secondFilter", urlPatterns = "/first/*")
@WebFilter(filterName = "secondFilter")
public class SecondFilter implements Filter {

    public SecondFilter() {
        System.out.println("SecondFilter 인스턴스 생성");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("SecondFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("SecondFilter doFilter");


        // 해당 필터 적용 후 또 적용할 필터가 있다면 다음 필터로 전달(없다면 서블릿으로)
        /* 설명. FilterChain에서 제공하는 doFilter는 다음 필터 또는 서블릿으로 진행하라는 의미이다. */
        filterChain.doFilter(servletRequest, servletResponse);

        /* 이 위치까지 전처리
         *
         * 해당 위치에서 servlet 처리가 이루어 진다. Business Logic
         *
         * 이후 부분에서 후처리
         */
        System.out.println("서블릿 다녀온 후");
    }

    @Override
    public void destroy() {
        System.out.println("SecondFilter destroy");
    }
}
