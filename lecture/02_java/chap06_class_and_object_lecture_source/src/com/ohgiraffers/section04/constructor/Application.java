package com.ohgiraffers.section04.constructor;

public class Application {
    public static void main(String[] args) {
        /* 수업목표. 생성자 함수가 무엇인지 이해하고 선언 및 호출할 수 있다. */
        User user1 = new User();
        System.out.println(user1.information());

        User user2 = new User("hong", "hong123", "홍길동");
        System.out.println(user2.information());

        // Date는 참조 자료형 변수 -> 기본 생성자를 이용하여 객체를 생성하여 전달
        User user3 = new User("hong", "hong123", "홍길동", new java.util.Date());
        System.out.println(user3.information());
    }
}