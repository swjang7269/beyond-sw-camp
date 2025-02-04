package com.ohgiraffers.section02.abstractclass;

// 추상 클래스(abstract class)는 객체 생성 불가
public abstract class Product {
    private int nonStaticField;
    private static int staticField;

    public Product() {
    }

    public void nonStaticMethod() {}

    public static void staticMethod() {}

    /* 설명. 추상 메소드가 하나라도 있으면 해당 클래스는 추상 클래스가 되어야 한다. */
    // 추상 메소드(구현부가 없는 메소드) -> 상속받은 자식 클래스는 무조건 오버라이드 해야함 (부모 클래스가 자식 클래스에게 주는 규약, 강제성)
    public abstract void abstractMethod();
}
