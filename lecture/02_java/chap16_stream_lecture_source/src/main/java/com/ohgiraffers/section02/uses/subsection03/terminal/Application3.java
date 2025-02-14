package com.ohgiraffers.section02.uses.subsection03.terminal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application3 {
    public static void main(String[] args) {
        /* 수업목표. 스트림의 최종 연산 중 하나인 Collect에 대해 이해하고 사용할 수 있다. */
        /* 설명.
         *  collect()는 Collector 객체에서 제공하는 정적(static) 메소드를 사용할 수 있고
         *  해당 메소드들을 통해 일반적으로 컬렉션(List, Set, Map)으로 변환할 수 있다.
         */
        List<Member> memberList = Arrays.asList(
                new Member("test01", "testName01"),
                new Member("test02", "testName02"),
                new Member("test03", "testName03")
        );

        List<String> collectorCollection = memberList.stream() // memberList를 stream으로 바꾸고
//              .map(x -> x.getMemberName)
                .map(Member::getMemberName) // getMemberName을 통해 이름만 추출
                .collect(Collectors.toList()); // 추출한 이름을 리스트로 만들어 반환
        collectorCollection.forEach(System.out::println); // 이름만 추출한 리스트 출력

        /* 설명. joining()은 요소들을 하나로 합쳐서 하나의 문자열로 바꿔주는 메소드 */
        String str = memberList.stream()
                .map(Member::getMemberName) // 멤버들의 이름을 추출하여
                .collect(Collectors.joining(" ")); // 하나의 문자열로 합치자(구분자 없으면 그냥 이어붙이기)
        System.out.println("str = " + str);

        // 구분자(delimiter), 접두사(prefix), 접미사(suffix) 설정 가능
        String str2 = memberList.stream()
                .map(Member::getMemberName) // 멤버들의 이름을 추출하여
                .collect(Collectors.joining("||", "**", "!!")); // 하나의 문자열로 합치자(구분자 없으면 그냥 이어붙이기)
        System.out.println("str2 = " + str2);
    }
}
