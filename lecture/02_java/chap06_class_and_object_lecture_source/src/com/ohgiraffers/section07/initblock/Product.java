package com.ohgiraffers.section07.initblock;

public class Product {
    // 클래스 변수 -> static 초기화 블럭 -> 인스턴스 초기화 블럭 순
    private String name = "아이폰";    // 상품명
    private int price;                // 상품 단가
    private static String brand;      // 제조사

    // 인스턴스 초기화 블럭
    // 중괄호만으로도 사용 가능
    // 어떤 생성자를 통해 생성하더라도 공통적으로 실행되어야할 로직이 있다면
    // 초기화 블럭을 이용하여 설정 가능
    /* 설명. 초기화 블럭은 생성자 이전에 실행되며 어떤 생성자로 객체를 생성하든 공통적인 로직이 있다면 작성 */
    {
        System.out.println("나도 있어...");
        price = 170;
        brand = "삼성";
    }

    // 순서와 상관없이 static 초기화가 인스턴스 초기화보다 먼저 일어난다.
    static {
//        price = 300   // static 초기화 블럭에서는 인스턴스 변수에 접근이 불가능
        brand = "LG";    // static 변수는 접근 가능
    }

    // 클래스 처음부터 생성자까지 실행해야 객체가 생성됨.
    public Product() {
        System.out.println("Product 기본 생성자 호출..");
        name = "샤오미폰";
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +        // '\' 뒤에 있는 것은 단순 문자로 받아들여라
                ", price='" + price + '\'' +    // 문법적 싱글 쿼테이션이 아니다.
                ", brand='" + brand + '\'' +
                '}';
    }
}


