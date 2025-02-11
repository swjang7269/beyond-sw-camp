package com.ohgiraffers.section01.list.run;

import java.util.Stack;

public class Application4 {
    public static void main(String[] args) {
        /* 수업목표. Stack에 대해 이해하고 사용할 수 있다. */
        /* 설명.
         *  Stack이란?
         *   LIFO(Last In First Out) 또는 FILO의 자료구조로 push(), pop(), peek() 등의 메소드를
         *   활용하여 자료를 처리할 수 있다.
         */

        /* 설명. Stack 객체 생성 후 데이터 추가 */
        /* 설명.
         *  push(): 값 삽입
         *  pop(): 값 꺼내서 확인
         *  peek(): 스택 최상단 값 확인(pop은 아님) (pop하면 나올 애)
         *  search(): 해당 값이 스택 상단으로 부터 몇 번째에 존재하는지 탐색
         */
        Stack<Integer> integerStack = new Stack<Integer>();

        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);
        integerStack.push(4);
        integerStack.push(5);


        System.out.println("integerStack = " + integerStack);

        /* 설명. Stack은 마지막부터 하나씩 순차적으로 카운팅 한다.(feat. 동등 비교가 가능해야 한다.(e, h 오버라이딩(equals, hashcode)) */
        System.out.println("search(): " + integerStack.search(2));
    }
}
