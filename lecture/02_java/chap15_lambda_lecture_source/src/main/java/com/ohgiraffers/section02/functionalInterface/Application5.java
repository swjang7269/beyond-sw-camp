package com.ohgiraffers.section02.functionalInterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Application5 {
    public static void main(String[] args) {
        /* 수업목표. 표준 함수적 인터페이스 중 Predicate에 대해 이해하고 사용할 수 있다. */
        // 설명. 매개변수가 있고 boolean 리턴 타입을 가지고 있다.
        Predicate<Object> predicate = value -> value instanceof String;
        System.out.println(predicate.test("hello"));
        System.out.println(predicate.test(123));

        BiPredicate<Double, Double> biPredicate = (x, y) -> x > y;
        System.out.println(biPredicate.test(3.14, 2.0));
        System.out.println(biPredicate.test(1.1, 2.2));
    }
}
