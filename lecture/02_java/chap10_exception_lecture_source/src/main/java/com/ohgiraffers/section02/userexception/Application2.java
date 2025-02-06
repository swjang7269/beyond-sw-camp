package com.ohgiraffers.section02.userexception;

public class Application2 {
    public static void main(String[] args) {
        /* 수업목표. finally를 활용한 try-catch를 이해하고 활용하기 */
        /* 설명. finally는 예외 처리 발생하든 안하든 무조건 실행 */
        ExceptionTest et = new ExceptionTest();
        try {
            et.checkEnoughMoney(20000, 50000);
            et.checkEnoughMoney(-20000, 50000);
        } catch (Exception e) {
            System.out.println("유효성 검사 시 문제 발생: " + e.getMessage());
        } finally {
            /* 설명. try 구문에서 예외가 발생하든 발생하지 않든 실행할 구문이 있다면 작성 */
            System.out.println("finally 블럭의 내용 동작");
        }
        System.out.println("프로그램 종료");
    }
}
