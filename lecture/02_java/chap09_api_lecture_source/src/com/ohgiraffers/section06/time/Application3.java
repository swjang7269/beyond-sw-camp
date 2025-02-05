package com.ohgiraffers.section06.time;

import java.time.LocalDateTime;

public class Application3 {
    public static void main(String[] args) {
        /* 설명. 불변 객체이므로 매번 변화가 생기면 새로운 객체가 생성된다. */
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("현재 시간: " + localDateTime);
        System.out.println("주소값: " + System.identityHashCode(localDateTime));

        LocalDateTime localDateTime2 = localDateTime.plusMinutes(30);
        System.out.println("30분 후: " + localDateTime2);
        System.out.println("주소값: " + System.identityHashCode(localDateTime2));

        LocalDateTime localDateTime3 = localDateTime.minusHours(3);
        System.out.println("3시간 전: " + localDateTime3);
        System.out.println("주소값: " + System.identityHashCode(localDateTime3));
    }
}
