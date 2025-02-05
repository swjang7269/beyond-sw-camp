package com.ohgiraffers.section03.interfaceImplements;

// 인터페이스는 다중 상속이 가능하다.
public interface InterProduct extends ParentInterProduct, AnotherParentInterProduct {
//    public static final int MAX_NUM = 100;    // interface는 어차피 public static final이다.
    int MAX_NUM = 100;  // 상품이 최대 100개만 저장 가능하고 변동 없이 이 값을 활용해라.

    /* 설명. 인터페이스는 생성자를 가질 수 없다. (feat.객체를 만들 수 없다.) */
//    public InterProduct() {}

    // 어차피 인터페이스는 추상 메소드만 가진다. (abstract 명시 안해도 문제 없음)
//    public abstract void nonStaticMethod();
    void nonStaticMethod();


    // 규약의 의미가 없어짐 -> 바디부분을 구현한다는 것은 overriding 필수가 아니라는 것
    /* 설명. static 메소드를 사용하면 메소드의 바디부분까지 작성이 가능하다.(JDK 1.8부터 추가) */
    public static void staticMethod() {

    }

    /* 설명. non-static 메소드도 default 키워드를 사용하면 메소드의 바디부분까지 작성이 가능하다.(JDK 1.8부터 추가) */
    public default void defaultMethod() {

    }

    /* 설명. 접근 제어자가 private인 메소드는 메소드의 바디부분까지 작성이 가능하다.(feat. default도 없이) */
    private void privateMethod() {

    }
}
