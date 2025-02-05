package com.ohgiraffers.section03.interfaceImplements;

// 내용이 비어있는 인터페이스 -> 마커 인터페이스
// 사용 이유 -> 서로 다른 타입을 하나의 타입으로 묶어서 관리하고 싶을 때 사용
// 타입만 상속시킴
public class Application {
    public static void main(String[] args) {
        /* 수업목표. 인터페이스(interface)에 대해 이해할 수 있다. */
        /* 설명.
         *  인터페이스란?
         *   자바의 클래스와 유사한 형태지만 상수 필드(public static final)와
         *   추상 메소드(public abstract)만 가질 수 있는 클래스의 변형체이다.
         */

//        InterProduct ip1 = new InterProduct
        Product p = new Product();
        InterProduct p2 = new Product();    // 인터페이스도 다형성 적용 가능, 부모 역할은 해준다.
        p2.nonStaticMethod();
    }
}
