package com.ohgiraffers.section01.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        MemberService memberService = context.getBean("memberService", MemberService.class);
        System.out.print("members: ");
        memberService.findAllMembers().forEach(System.out::println);

        System.out.println("====== 회원 한 명 조회 =====");
        System.out.println(memberService.fineMerberBy(1));
        /* 설명. AfterReturning까지 고려한 회원 수(3명) 보다 더 큰 범위를 조회하면 예외 발생(AfterThrowing) */
//        System.out.println(memberService.fineMerberBy(3)); // 예외 발생 시 AfterThrowing 동작
    }
}
