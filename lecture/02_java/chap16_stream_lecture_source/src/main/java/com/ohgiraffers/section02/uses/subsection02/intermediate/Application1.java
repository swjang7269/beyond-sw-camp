package com.ohgiraffers.section02.uses.subsection02.intermediate;

import java.util.stream.IntStream;

public class Application1 {
    public static void main(String[] args) {
        /* 수업목표. 스트림의 중계 연산 중 하나인 filter에 대해 이해하고 사용할 수 있다. */
        /* 설명. 중계 연산: Stream을 반환하며 Stream 관련 메소드 체이닝 상에서 중간에 위치한다.  */

        /* 설명. 필터(filter)는 스트림에서 특정 데이터만들 걸러내기 위한 메소드이다. */
        // 해당 필터에 대해 해당(True)하는 친구만 반환(boolean 타입 반환 값을 가진 람다식을 넣는다.)
        IntStream intStream = IntStream.range(0, 10);
        // intStream을 i가 순회하며 i % 2 == 0인 i만 모은 Stream을 반환
        intStream.filter(i -> i % 2 == 0).forEach(i -> System.out.print(i + " ")); // 람다식은 predicate 타입

    }
}
