package com.ohgiraffers.section02.functionalInterface;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class Application4 {
    public static void main(String[] args) {
        /* 수업목표. 표준 함수적 인터페이스 중 Operator에 대해 이해하고 사용할 수 있다. */
        /* 설명. Function과 유사하지만 매개변수 타입과 반환형이 같다. */
        // 매개변수와 반환형이 존재
        UnaryOperator<String> unaryOperator = str -> str + "world";
        System.out.println(unaryOperator.apply("hello "));

        BinaryOperator<String> binaryOperator = (str1, str2) -> str1 + str2;
        System.out.println(binaryOperator.apply("nice to ", "meet u"));
    }
}
