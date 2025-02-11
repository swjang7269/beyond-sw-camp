package com.ohgiraffers.section02.run;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Application1 {
    public static void main(String[] args) {
        /* 수업목표. Set 자료구조의 특성을 이해하고 hashSet을 이용할 수 있다. */
//        HashSet<String> hset = new HashSet<>();
        Set<String> hset = new HashSet<>();
        hset.add(new String("java"));
        hset.add(new String("mariaDB"));
        hset.add(new String("servlet"));
        hset.add(new String("spring"));
        hset.add(new String("html"));

        /* 설명. Set에 저장된 자료는 넣는 순서를 보장할 수는 없다.(넣는 순서와 다르다.) */
        // 내부적으로 저장하는 순서가 정해져 있으나, 사용자가 넣은 순서대로 저장하지는 않는다.
        System.out.println("hset = " + hset);

        /* 설명. 중복되는 데이터 추가(feat. 중복은 동등객체를 말한다.) */
        // 값이 같지만 다른 객체를 넣더라도 중복을 허용하지 않는다.(e, h 오버라이드)
        hset.add(new String("java"));
        System.out.println("추가후 hset = " + hset);   // 삽입 전 후 변화가 없다.

        /* 설명. Set은 인덱스 개념이 없어 Iterator(반복자)를 활용하여야 한다. */
        Iterator<String> iter = hset.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
        System.out.println();

        /* 설명. Set을 배열로 바꿀 수는 있다.(권장하진 않는다.) (오브젝트 배열로 반환하여 다운캐스팅이 필요) */
        Object[] arr = hset.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println((String)arr[i]);
        }

        System.out.println("size() = " + hset.size());
        hset.clear();
        System.out.println("size() = " + hset.size());
        System.out.println("isEmpty() = " + hset.isEmpty());
    }
}
