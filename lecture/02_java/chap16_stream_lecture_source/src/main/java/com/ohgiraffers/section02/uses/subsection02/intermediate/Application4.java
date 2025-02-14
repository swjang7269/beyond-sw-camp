package com.ohgiraffers.section02.uses.subsection02.intermediate;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Application4 {
    public static void main(String[] args) {
        /* 수업목표. 스트림의 중계 연산 중 하나인 flatMap에 대해 이해하고 사용할 수 있다. */
        List<List<String>> list = Arrays.asList(
          Arrays.asList("JAVA", "SPRING", "SPRINGBOOT"),
          Arrays.asList("java", "spring", "springboot")
        );

        list.stream().forEach(System.out::println);
        System.out.println("list = " + list);

        List<String> flatList = list.stream().flatMap(Collection::stream) // depth를 1로 일차원으로(flat)하게 만든다.
                .collect(Collectors.toList());  // 결과를 list로
        flatList.stream().forEach(System.out::println);
        System.out.println("flatList = " + flatList);
    }
}
