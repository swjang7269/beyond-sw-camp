package com.ohgiraffers.section06.statickeyword;

public class StaticTest {
    private int nonStaticCount;         // 인스턴스 변수 -> 인스턴스를 만들어야 하는 변수
    private static int staticCount;     // static 변수는 클래스 변수라고도 불림 -> 인스턴스 생성이 필요 없음

    // static 필드와 관련된 메소드는 static을 대개 사용
    // 해당 클래스의 역할과 크게 상관이 없기 때문
    public StaticTest() {
    }

    // Getter
    public int getNonStaticCount() {
        return nonStaticCount;
    }

    public static int getStaticCount() {
        return staticCount;
    }

    // 각 필드 증가 메소드
    // 같은 클래스에 있고, 중복 이름이 없어 this와 StaticTest 생략 가능
    public void increaseNonStaticCount() {
        this.nonStaticCount++;
    }

    public static void increaseStaticCount() {
        StaticTest.staticCount++;
    }
}
