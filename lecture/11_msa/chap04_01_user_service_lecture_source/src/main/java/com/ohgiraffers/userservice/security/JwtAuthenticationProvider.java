package com.ohgiraffers.userservice.security;

import com.ohgiraffers.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/* 설명. Jwt 토큰 방식의 로그인을 구경할 때 UsernamePasswordAuthenticationToken을 처리할 Provider */
/* 설명. Service 계층을 UserDetailsService 타입으로 바꾸고 옴 */
@Slf4j
@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    public JwtAuthenticationProvider(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String pwd = authentication.getCredentials().toString();

        UserDetails userDetails = userService.loadUserByUsername(email);

        if(!passwordEncoder.matches(pwd, userDetails.getPassword())) {
            throw new BadCredentialsException("비밀번호 불일치");
        }

        /* 설명. 예외가 발생하지 않으면 인증된 회원 정보라는 뜻이다. */

        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }

    // 해당 토큰을 처리할 수 있다고 등록
    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
