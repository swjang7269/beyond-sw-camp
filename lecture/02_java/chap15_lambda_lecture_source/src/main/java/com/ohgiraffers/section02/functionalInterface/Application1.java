package com.ohgiraffers.section02.functionalInterface;

import java.time.LocalTime;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

public class Application1 {
    public static void main(String[] args) {
        /* 수업목표. 표준 함수적 인터페이스 중 Consumer에 대해 이해하고 사용할 수 있다. */
        /* 설명. 반환형이 없는 메소드 관련 람다식 */
//        Consumer<String> consumer = (str) -> {
//            System.out.println(str + "(이)가 입력됨.");
//        };
        Consumer<String> consumer = str -> System.out.println(str + "(이)가 입력됨.");

        consumer.accept("피카츄");
        consumer.accept("집 가고 싶다.");

        BiConsumer<String, LocalTime> biConsumer =
                (str, time) -> System.out.println(str + "(이)가 " + time + "에 입력됨");
        biConsumer.accept("Hello", LocalTime.now());

        /* 설명.
         *  (int)(Math.random() * 갯수) + 초기값
         *  new Random().nextInt(갯수) + 초기값 (다운캐스팅을 할 필요가 없다.)
         */
        ObjIntConsumer<Random> objiIntConsumer =
                (random, bound) -> System.out.println("1부터 " + bound + "까지의 난수 발생: "
                + (random.nextInt(bound) + 1));
        objiIntConsumer.accept(new Random(), 10);
    }
}
