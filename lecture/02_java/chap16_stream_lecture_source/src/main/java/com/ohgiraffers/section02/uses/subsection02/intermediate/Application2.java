package com.ohgiraffers.section02.uses.subsection02.intermediate;

import java.util.stream.IntStream;

public class Application2 {
    public static void main(String[] args) {
        /* 수업목표. 스트림의 중계 연산 중 하나인 map에 대해 이해하고 사용할 수 있다. */
        /* 설명. 맵(map)은 스트림에 들어있는 데이터를 람다식으로 가공하고 새로운 스트림에 담아주는 메소드이다. */

        // 데이터를 해당 람다식에 넣어 나온 반환값을 받음 map - operator(매개변수와 반환형이 일치)
        IntStream intStream = IntStream.range(1, 10);
        intStream.filter(i -> i % 2 != 0)   // i % 2 != 0인 애들만 모아서 (predicate)
                .map(i -> i * 5)            // i * 5를 한 애들을 반환     (operator)
                .forEach(result -> System.out.print(result + " ")); // (consumer)
    }
}
