package com.ohgiraffers.section06.singleton;

public class LazySingleton {
    private static LazySingleton lazy;

    private LazySingleton() {

    }

    // 메소드 호출시 객체 생성 그리고 추가 생성을 막기위해 조건문 추가
    public static LazySingleton getInstance() {
        if (lazy == null)
            lazy = new LazySingleton();

        return lazy;
    }
}
