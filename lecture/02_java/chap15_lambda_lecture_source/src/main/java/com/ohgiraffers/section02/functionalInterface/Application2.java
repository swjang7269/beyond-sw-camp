package com.ohgiraffers.section02.functionalInterface;

import java.time.LocalDateTime;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

public class Application2 {
    public static void main(String[] args) {
        /* 수업목표. 표준 함수적 인터페이스 중 Supplier에 대해 이해하고 사용할 수 있다. */
        /* 설명. 매개변수 없고 반환값만 있는 메소드 관련 람다식 */
        // 매개변수가 없을 땐, ()생략 불가
        Supplier<LocalDateTime> supplier = () -> LocalDateTime.now();   //  supplier의 get() 오버라이드
        System.out.println(supplier.get()); // LocalDateTime.now()가 동작

        BooleanSupplier booleanSupplier = () -> {
            int random = (int) (Math.random() * 2);
            return random == 0 ? false : true;
        };
        System.out.println("랜덤 true or false 생성기: " + booleanSupplier.getAsBoolean());
    }
}
