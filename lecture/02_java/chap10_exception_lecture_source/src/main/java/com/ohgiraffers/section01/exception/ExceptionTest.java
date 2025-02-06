package com.ohgiraffers.section01.exception;

public class ExceptionTest {
    // ArithmeticException의 경우 unchecked exception으로 기본적으로 설정이 되어 있기 때문에 throws를 안적어도 문제가 일어나지 않는다.
    // 그러나 사용자 설정 exception의 경우 throws를 명시해주어야 한다.
    public void checkEnoughMoney(int price, int money) /* throws ArithmeticException */ {
        System.out.println("소유금: "+money);
        if(money >= price){
            System.out.println(price + "해당 상품을 구매하기 위한 금액이 충분");
            return;
        }

//        System.out.println("돈이 없구마이");

        /* 설명. 예외 상황에 Exception을 상속 받는 클래스의 객체를 생성하고 클래스의 객체를 생성하고 thorw로 발생*/
        throw new ArithmeticException("돈이 부족합니다.");
    }
}
