package com.ohgiraffers.userservice.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohgiraffers.userservice.vo.RequestLoginVO;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.ArrayList;

/*
 * 설명. JWT(Json Web Token)의 구조
 *
 * 설명.
 *  1. 헤더(Header)
 *    - typ: 토큰의 타입 지정(JWT)
 *    - alg: 해싱 알고리즘으로 Verify Signature에서 사용 됨
 * 설명.
 *  2. 내용 또는 정보(Payload)
 *    - 토큰에 담을 정보가 들어 있음
 *    - 담는 정보의 한 조각을 클레임(claim - name과 value의 쌍으로 구성)이라 부름
 *       a. 등록된 클레임(registered claim)
 *          : 토큰에 대한 정보가 담김
 *            (iss: 토큰 발급자(issuer)
 *             sub: 토큰 제목(subject)
 *             aud: 토큰 대상자(audience)
 *             exp: 토큰의 만료 시간(expiration)
 *             nbf: 토큰 활성화(발급) 날짜(not before)
 *             iat: 토큰 활성화(발급) 시간(issued at))
 * 설명.
 *       b. 공개 클레임(public claim)
 *          : 사용자 정의 클레임으로 공개용 정보를 위해 사용(충돌 방지를 위해 URI로 구성)
 * 설명.
 *       c. 비공개 클레임(private claim)
 *         : 사용자 정의 클레임으로 서버(JWT 발급자)와 클라이언트 사이에 임의로 지정한 정보를 저장
 *            (충돌 발생 우려가 있어 조심해서 사용할 것)
 * 설명.
 *  3. 서명(Verify Signature)
 *    - Header 인코딩 값과 Payload 인코딩 값을 합쳐서 비밀 키로 해쉬(헤더의 해싱 알고리즘으로)하여 생성
 */

@Slf4j
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public AuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    // 로그인 시도 중에 걸리는 필터(인증 시도)
    /* 설명. 로그인 시도 시 동작하는 기능(POST /login 요청 시) */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            /* 설명. request를 통해 넘어온 json(login 시 id/pwd)를 RequestLoginVO 옮겨 담기 */
            RequestLoginVO creds = new ObjectMapper().readValue(request.getInputStream(), RequestLoginVO.class);

            return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(creds.getEmail(), creds.getPwd(), new ArrayList<>()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 로그인 성공 후 돌아올 때 걸리는 필터
    /* 설명. 로그인 성공 시 JWT 토큰 생성할 예정 */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        log.info("로그인 성공 이후 spring security가 Authentication 객체로 관리 되어 돌아옴: {}", authResult);


    }

}
