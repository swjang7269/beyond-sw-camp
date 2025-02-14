package com.ohgiraffers.section02.uses.subsection02.intermediate;

import java.util.Comparator;

// 정렬 기준을 내림차순으로 사용자 정의
public class DescInteger implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}
