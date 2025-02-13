package com.ohgiraffers.section01.intro;

/* 설명. Functional Interface만 람다식으로 적용 가능하다. */
@FunctionalInterface    // 추상 메소드를 한 개만 가지도록 가독성을 올려준다.(2개 이상이면 에러 표시)
public interface Calculator {
    int sumTwoNumbers(int first, int second);
}
