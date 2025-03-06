package com.ohgiraffers.exceptionhandler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Member;

@Controller
@RequestMapping("/*")
public class ExceptionHandlerController {
    @GetMapping("simple-null")
    public String simpleNullPointerExceptionTest() {
        if (true) {
            throw new NullPointerException();
        }

        return "/";
    }

    // exception은 상속받아 예외처리가 미리 작성되어 있지 않은 checked exception이므로 예외 처리를 해줘야 한다.
    @GetMapping("simple-user")
    public String userExceptionTest() throws MemberRegistException {
        if (true) {
            throw new MemberRegistException("Nob");
        }
        return "/";
    }

    @GetMapping("annotation-null")
    public String nullPointerExceptionTest() {
        String str = null;
        str.charAt(2);

        return "/";
    }

    // bean을 통해 에러 처리를 했더라도 지역적인 handler가 우선적으로 처리된다.
    @ExceptionHandler(NullPointerException.class)
    public String nullPointerExceptionHandler() {
        System.out.println("이 Controller에서 NullPointerException 발생 시 처리 가능한지");
        return "/error/default";
    }

    @GetMapping("annotation-user")
    public String userException() throws MemberRegistException {
        if(true) {
            throw new MemberRegistException("Noooob");
        }
        return "/";
    }

    @ExceptionHandler(MemberRegistException.class)
    public String userExceptionHandler() {

        return "/error/default";
    }
}
