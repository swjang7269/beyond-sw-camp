package com.ohgiraffers.section01.intro;

import java.util.Arrays;
import java.util.List;

public class Application1 {
    public static void main(String[] args) {
        /* 수업목표. Stream에 대해 이해하고 활용할 수 있다. */
        /* 설명.
         *  Arrays.asList(): 매개변수로 요소들을 전달하면 List로 반환
         *  ArraysList<>(Collection 타입): Collection 타입을 ArrayList 객체로 생성할 때 쓰이는 생성자
         */
        List<String> stringList = Arrays.asList("hello", "world", "stream");

        /* 설명. main 스레드 상에서 스트림을 사용하지 않고 확인 */
        System.out.println("===== for each");
        for(String str : stringList) {
            // 한 개의 스레드만을 사용하며 반복 조회
            System.out.println(str + ": " + Thread.currentThread().getName());
        }

        /* 설명. main 스레드 상에서 단순 스트림을 사용하고 확인( */
        // main 스레드상에서만 단순 처리 중
        System.out.println("===== normal stream");

        // 컬렉션은 stream()을 생략해도 된다.
//        stringList.stream().forEach(x -> Application1.print(x));
        stringList.forEach(x -> Application1.print(x));

        /* 설명. main 스레드 상에서 병렬 스트림을 사용하고 확인(cpu 코어 병렬 처리) */
        // 메인 스레드 이외에도 별개의 스레드(fork())도 병렬 사용
        System.out.println("===== parallel stream");
        stringList.parallelStream().forEach(x -> Application1.print(x)); // cpu 코어들을 효율적으로 사용해 성능 향상(속도 향상) -> 코테에서 유리
    }

    private static void print(String x) {
        System.out.println(x + ": " + Thread.currentThread().getName());
    }
}
