package com.ohgiraffers.section01.list.run;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Application3 {
    public static void main(String[] args) {
        /* 수업목표. List 계열을 출력하는 4가지 방법 */
        List<String> list = new ArrayList<String>();
//        List<String> list = new LinkedList<String>(); // list 계열이라 아래 코드상 에러 X
//        List<String> list = new Vector<String>(); // list 계열이라 아래 코드상 에러 X
//        -> 내부적으로 동기화 처리가 돌아가고 있다. -> 멀티 스레드 환경 고려 -> 속도가 조금 느림
        // 동기화 처리를 위한 알고리즘이 추가되어 있다.

        list.add("apple");
        list.add("banana");
        list.add("grape");
        list.add("orange");
        list.add("mango");

        /* 설명. 1. toString() 활용하기 */
        System.out.println(list);

        /* 설명. 2. for문 활용하기 */
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        /* 설명. 3. for-each문 활용하기 */
        for (String str : list) {
            System.out.println(str);
        }

        /* 설명. 4. iterator 활용하기 */
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        /* 설명. 1번 인덱스(두 번째)의 과일 수정 */   // ArrayList일 경우 더 좋음
        list.set(1, "pineapple");
        System.out.println("2번째 요소 수정 후: " + list);

        /* 설명. list가 관리하는 요소 제거 */      // LinkedList일 경우 더 좋음
        /* 설명. 3번째 요소  제거 */
        list.remove(2);
        System.out.println(list);

        list.clear();   // 객체는 있고 내부 내용물만 제거 isEmpty -> true
        System.out.println("모든 요소 제거후 : " + list);

        // null을 대입하면 이후 list를 활용하는 곳에서는 NullpointerException이 발생할 수 있다.
//        list = null;    // list 저장 공간 자체를 제거 --> null과 empty는 다름

        /* 설명. 모든 요소가 제거 된 이후 */
        System.out.println("isEmpty: " + list.isEmpty());   // 객체는 존재하나 안의 내용물이 없는 경우 isEmpty = true

        /*설명. 'null'과 '객체는 있지만 비어있음'을 잘 구분하자 */
    }
}
