package com.ohgiraffers.forward;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/forward")
public class ReceiveInformationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");

        System.out.println("userId = " + userId);
        System.out.println("password = " + password);

        /* 설명.
         *  이 부분에서 id와 pwd에 해당하는 user의 정보를 DB까지 가서 select하고 확인하는
         *  비즈니스 로직(BL)이 수행되어야 한다.(그 결과는 회원의 정보를 조회해 옴)
         *  제대로 조회되었다는 가정 하에 'XXX님 환영'와 같은 메시지를 출력하는
         *  화면을 동적으로 만들어 응답해 보겠다.
         */

        req.setAttribute("userName", "홍길동");

        // rd를 만들어 위임할 대상의 경로를 입력하여 서블릿의 상태를 넘겨주어 요청 처리를 위임한다.
        RequestDispatcher rd = req.getRequestDispatcher("print");
        rd.forward(req, resp);
    }
}
