package com.ohgiraffers.section02.uses;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class RequestWrapper extends HttpServletRequestWrapper {
    public RequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String key) {
        /* 설명. 'password'라는 키값으로 getParameter 메소드 사용 시에는 암호화된 값을 반환하도록 재정의 */
        String value = "";
        if ("password".equals(key)) {   // key값으로 "password"가 넘어올 때
            System.out.println("패스워드 꺼낼 시");
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            value = passwordEncoder.encode(super.getParameter(key));
            System.out.println("암호화 된 패스워드: " + value);
        } else {    // 그 외의 입력은 기존과 동일하도록
            value = super.getParameter(key);
        }
        return value;
    }
}
