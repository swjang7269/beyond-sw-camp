package com.ohgiraffers.section06.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class Application4 {
    public static void main(String[] args) {
        /* 수업목표. time 패키지의 클래스가 제공하는 날짜 비교 연산 메소드를 활용할 수 있다. */
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.now();

        LocalDate past = LocalDate.of(2022,11,11);
        LocalDateTime future = LocalDateTime.of(2026, 3, 6, 14, 11, 23);
        ZonedDateTime now = zonedDateTime;

        /* 설명. 이전, 이후, 같은 날짜인지 확인(각 time 패키지 자료형마다 전달인자가 같은 타입이어야 동작) */
        System.out.println(localDate.isAfter(past));
        System.out.println(localDateTime.isBefore(future));
        System.out.println(zonedDateTime.isEqual(now));
    }
}
