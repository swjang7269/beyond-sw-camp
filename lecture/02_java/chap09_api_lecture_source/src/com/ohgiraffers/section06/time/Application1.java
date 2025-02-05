package com.ohgiraffers.section06.time;

import java.time.*;

public class Application1 {
    public static void main(String[] args) {
        /* 수업목표.  time 패키지에서 제공하는 클래스들의 사용 방법을 이해할 수 있다.*/
        LocalTime timeNow = LocalTime.now();
        LocalTime timeNow2 = LocalTime.of(15,22,34);
        System.out.println("timeNow = " + timeNow);
        System.out.println("timeNow2 = " + timeNow2);

        LocalDate dateNow = LocalDate.now();
        LocalDate dateOf = LocalDate.of(2000,11,30);    // month에 -1을 할 필요가 없다.
        System.out.println("dateNow = " + dateNow);
        System.out.println("dateOf = " + dateOf);

        LocalDateTime dateTimeNow = LocalDateTime.now();
        LocalDateTime dateTimeOf = LocalDateTime.of(2000,11,30, 5, 10, 40);    // month에 -1을 할 필요가 없다.
        System.out.println("dateTimeNow = " + dateTimeNow);
        System.out.println("dateTimeOf = " + dateTimeOf);

        ZonedDateTime zonedDateTimeNow = ZonedDateTime.now();
        ZonedDateTime zonedDateTimeOf = ZonedDateTime.of(dateOf, timeNow2, ZoneId.of("Asia/Seoul"));
        System.out.println("zonedDateTimeNow = " + zonedDateTimeNow);
        System.out.println("zonedDateTimeOf = " + zonedDateTimeOf);
    }
}
