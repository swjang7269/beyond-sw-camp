package com.ohgiraffers.section02.uses.subsection03.terminal;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Application1 {
    public static void main(String[] args) {
        /* 수업목표. 스트림의 최종연산(Terminal Operator) 중 하나인 calculation에 대해 이해하고 사용할 수 있다. */
        long count = IntStream.range(1, 10).count(); // 갯수
        int sum = IntStream.range(1, 10).sum(); // 총합

        System.out.println("count = " + count);
        System.out.println("sum = " + sum);

        OptionalInt max = IntStream.range(1, 10).max();  // 없다 라는 개염을 empty로 처리 가능한 타입
        System.out.println("max = " + max);

        OptionalInt m = IntStream.range(1, 1).max(); // 기본 자료형도 존재하지 않으면 empty
        System.out.println("m = " + m);

        OptionalInt min = IntStream.range(1, 10).min();
        System.out.println("min = " + min);

        int oddSum = IntStream.range(1, 19).filter(i -> i % 2 != 0).sum();
        System.out.println("oddSum = " + oddSum);
    }
}
