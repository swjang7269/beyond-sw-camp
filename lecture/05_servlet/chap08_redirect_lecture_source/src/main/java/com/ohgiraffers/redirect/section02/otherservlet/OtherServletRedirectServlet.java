package com.ohgiraffers.redirect.section02.otherservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/otherservlet")
public class OtherServletRedirectServlet extends HttpServlet {
    // GET으로 재 요청을 받는것이기제 처음 요청이 get이든, post이든 doGet으로 받으면 된다.
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("test", "abc");
//        resp.sendRedirect("redirect");

        /* 설명. redirect를 해서 다시 다른 서블릿으로 갈 때 파라미터로 추가하면 어느정도 상태를 전달할 수 있다.(데이터가 커지고 복잡해지면 전달에 한계) */
        resp.sendRedirect("redirect?test=" + req.getAttribute("test")); // parameter로는 전달 가능
    }
}
