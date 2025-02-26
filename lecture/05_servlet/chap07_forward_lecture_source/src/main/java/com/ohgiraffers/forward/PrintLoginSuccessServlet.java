package com.ohgiraffers.forward;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/print")
public class PrintLoginSuccessServlet extends HttpServlet {

    // 위임하는 타입과 동일한 메소드로 처리(post로 위임하면 post로 처리, get으로 위임하면 get으로 처리)
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("==== 포워딩되어 서블릿에서 넘겨받은 request 객체에 담긴 값 확인 ====");
        System.out.println("이름: " + req.getAttribute("userName"));
        System.out.println("아이디: " + req.getParameter("userId"));
        System.out.println("패스워드: " + req.getParameter("password"));

        String userName = (String)req.getAttribute("userName");
        StringBuilder responseText = new StringBuilder();
        responseText.append("<h3>")
                .append(userName)
                .append("님 환영합니다.</h3>");

        resp.setContentType("text/html; charset=utf-8");

        PrintWriter out = resp.getWriter();
        out.print(responseText);
        out.flush();
        out.close();
    }
}
