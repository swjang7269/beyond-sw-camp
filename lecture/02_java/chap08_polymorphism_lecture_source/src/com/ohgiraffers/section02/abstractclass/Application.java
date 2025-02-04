package com.ohgiraffers.section02.abstractclass;

public class Application {
    public static void main(String[] args) {
//        Product p = new Product();    // 추상 클래스는 객체 생성 불가
        Phone smartPhone1 = new Phone();
        smartPhone1.abstractMethod();

        Product smartPhone2 = new Phone();  // 다형성 적용 feat.객체만 만들지 못할 뿐 부모 역할은 가능
        smartPhone2.abstractMethod();

    }
}
