package com.ohgiraffers.section01.exception;

public class ExceptionTest {

    public void checkEnoughMoney(int price, int money) throws ArithmeticException {
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
