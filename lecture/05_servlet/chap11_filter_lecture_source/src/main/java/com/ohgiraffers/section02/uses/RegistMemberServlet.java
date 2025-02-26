package com.ohgiraffers.section02.uses;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.IOException;

@WebServlet("/member/regist")
public class RegistMemberServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        String name = req.getParameter("name"); // 한글 입력시 깨지지 않도록 인코딩 필터를 추가해주겠다.(이전 버전의 경우 깨진다)

        System.out.println("userId = " + userId);
        System.out.println("password = " + password);
        System.out.println("name = " + name);

        /* 설명. 사용자가 입력한(password는 암호화 된) 값들이 DB에 저장된 후 다시 사용자의 입력과 비교한다면? */
        /* 설명. 암호가 '1234'라고 가정 */
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println("비밀번호가 1234인지 확인: " + passwordEncoder.matches("1234", password));
        System.out.println("비밀번호가 5678인지 확인: " + passwordEncoder.matches("5678", password));
    }
}
