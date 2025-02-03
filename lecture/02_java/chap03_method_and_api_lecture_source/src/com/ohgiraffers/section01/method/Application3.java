package com.ohgiraffers.section01.method;

public class Application3 {
    static int global = 10;     // 해당 클래스(전역) 내부에서 사용 가능한 함수,
    // static 변수(클래스 변수) -> 프로그램 종료시까지 메모리에 등록
    public static void main(String[] args) {
        /* 수업목표. 메소드 전달인자(argument)와 매개변수(parameter)에 대해 이해하고 메소드 호출시 활용할 수 있다. */
        /* 설명.
         *  변수를 선언한 위치에 따라 구분할 수도 있다.
         *  1. 지역변수
         *  2. 전역변수
         *  3. 매개변수
         * */
        Application3 app3 = new Application3();
        app3.testMethod(26);
        System.out.println("전역 변수: " + global);
        int local = 20;
        System.out.println("지역 변수: " + local);  // 해당 에어리어(지역, 스코프) 내부에서만 사용 가능한 변수.
    }

    public void testMethod(int age) {
        System.out.println("당신의 나이는 " + age + "세 입니다.");
    }
}