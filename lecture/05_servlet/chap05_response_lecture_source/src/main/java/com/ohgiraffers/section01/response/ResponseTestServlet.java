package com.ohgiraffers.section01.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

// SSR(Server Side Rendering) - 서버 측에서 페이지를 만드는 것
// CSR(Client Side Rendering) - 클라이언트 측에서 페이지를 만드는 것
@WebServlet("/response")
public class ResponseTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder responseText = new StringBuilder();
        responseText.append("<!DOCTYPE html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h1>한글 servlet response</h1>\n")
                .append("</body>\n")
                .append("</html>");

        /* 설명. MIME 타입과 인코딩 설정을 해 주어야 한다. 다만 jakarta는 굳이 해주지 않아도 된다. */
        // tomcat 10버전 이후엔 자동으로 해주지만 그 이전 버전의 경우 스트림 생성 이전에 설정을 해줘야 한다.
        resp.setContentType("text/html");   // 해당 데이터가 html 파일이라는 것을 설정
        resp.setCharacterEncoding("UTF-8"); // 인코딩 방식 설정
//        resp.setContentType("text/html; charset=UTF-8");    // ';'을 통해 한 줄에 여러 설정을 해 줄수 있다.

        PrintWriter out = resp.getWriter(); // 요청이 들어온 곳과 통로 연결
        out.print(responseText);    // out을 통해 연결된 곳(요청을 보낸 곳/응답이 되돌아갈 곳)에 전송
        out.flush();
        out.close();
    }
}
