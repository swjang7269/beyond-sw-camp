package com.ohgiraffers.section01.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

// 어떤 서블릿에 접근할 때 해당 필터를 적용하는지
/* 설명. /first 이후 경로는 어떤 것이든 지금의 FirstFilter를 거치는 요청 경로가 된다.*/

/* 설명.
 *  WebFilter라는 어노테이션을 통해 필터 설정을 할 수 있지만 필터의 동작 순서를 원하는대로
 *  동작하게 하기 위해서는 Servlet에서는 web.xml을 활용한 xml방식의 설정을 통해서만 바꿔줄 수 있다.
 *  (필터의 동작 순서는 web.xml에 작성한 filter mapping의 순서에 따라 동작한다.)
 */
//@WebFilter(filterName = "secondFilter", urlPatterns = "/first/*")
@WebFilter(filterName = "firstFilter")
public class FirstFilter implements Filter {

    public FirstFilter() {
        System.out.println("FirstFilter 인스턴스 생성");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FirstFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FirstFilter doFilter");


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
        System.out.println("FirstFilter destroy");
    }
}
