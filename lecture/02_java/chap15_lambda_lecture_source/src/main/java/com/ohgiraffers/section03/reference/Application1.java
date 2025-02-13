package com.ohgiraffers.section03.reference;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Application1 {
    public static void main(String[] args) {
        /* 수업목표. 기존에 존재하는 메소드를 참조해 람다식을 적용할 수 있다. */
        BiFunction<String, String, Boolean> biFunction;

        String str1 = "METHOD";
        String str2 = "METHOD";

        boolean result = false;

//        biFunction = (x, y) -> x.equals(y); // 기존에 String에 존재하는 equals를 참조하여 람다식 적용
        biFunction = String::equals;    // String내의 equals를 참조

        result = biFunction.apply(str1, str2);
        System.out.println(result);

        // println은 System.out에 속한 함수이고 반환형이 없으므로 Consumer 타입을 사용하여 참조 가능
        Consumer<String> consumer = System.out::println;
        consumer.accept("되는건가");
    }
}
