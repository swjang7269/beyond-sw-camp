package com.ohgiraffers.section06.singleton;

// 프로그램 실행시 이미 자신의 객체를 만들어 저장 및 메모리에 등록 -> 다른 클래스에서 추가로 생성을 못하도록,
// static 메소드를 이용하여 해당 객체를 받아낼 수 있도록 설계
// 프로그램 실행하자 마자 객체를 한개 만드는 eagersingleton
public class EagerSingleton {
    private static EagerSingleton eager = new EagerSingleton();

    // 기본 생성자를 private로 만들어 다른 클래스에서 생성 못하도록 캡슐화 <- 중요 포인트
    private EagerSingleton() {

    }

    public static EagerSingleton getInstance(){
        return eager;
    }
}
