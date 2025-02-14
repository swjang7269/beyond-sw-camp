package com.ohgiraffers.section02.uses.subsection02.intermediate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Application3 {
    public static void main(String[] args) {
        /* 수업목표. 스트림의 중계 연산 중 하나인 sorted에 대해 이해하고 사용할 수 있다. */
        List<Integer> integerList = IntStream.of(5,10,99,2,1,35)    // 특정 값을 순차적으로 stream으로 만든다.
                .boxed()
                .sorted(new DescInteger())   // 오름차순 정렬(사용자 정의한 기준을 넣어주면 사용자 기준에 맞춰 정렬해준다.)
                .collect(Collectors.toList());  // 컬렉션으로 바꿈(해당 예제에선 List로)
        System.out.println(integerList);
    }
}
