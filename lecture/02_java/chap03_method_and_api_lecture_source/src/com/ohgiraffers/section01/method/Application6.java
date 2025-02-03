package com.ohgiraffers.section01.method;

public class Application6 {
    public static void main(String[] args) {
        /* 수업목표. 반환값이 있는 메소드를 작성할 수 있다. */
        String result = testMethod();
        System.out.println("result = " + result);
        System.out.println("testMethod() = " + testMethod());
    }

    private static String testMethod() {
        System.out.println("testMethod() 실행됨...");
        return "test";
    }
}
