package com.ohgiraffers.section01.list.run;

import java.util.*;

/* 설명.
 *   ArrayList
 *       add, get(index)
 *   Stack
 *       push, pop
 *   Queue
 *       offer, poll
 */

public class Application5 {
    public static void main(String[] args) {
        /* 수업목표. Queue에 대해 이해하고 활용할 수 있다. */
        /* 설명.
         *  Queue란?
         *   선형 메모리 공간에 데이터를 저장하여 순서를 유지하기 위한 선입선출(FIFO) 방식의 자료구조이다.
         *   대부분 LinkedList를 많이 사용한다.
         *   (대용량 트래픽을 관리할 때 자주 사용)
         */
//        Queue que = new Queue(); // Queue의 생성자를 활용할 수 없다.(Queue의 구현체는 하위 타입으로 만들어야 한다.)
//        Queue<String> que = new LinkedList<String>();

        /* 설명. PriorityQueue를 활용하면 선입선출 + 정렬의 개념을 가져갈 수 있다. */
        // 저장되어 있는 순서는 heap 알고리즘을 이용해서 내부적으로 저장하고
        // 꺼낼때는 우선순위 대로 꺼내도록 동작
        // 같은 계층 비교하여 우선순위 높은 것을 올림
        Queue<String> que = new PriorityQueue<>(); // 오름차순
//        Queue<String> que = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순

        que.offer("first");
        que.offer("second");
        que.offer("third");
        que.offer("fourth");
        que.offer("fifth");
        System.out.println("que = " + que);

        System.out.println("peek(): " + que.peek());    // peek은 조회만
        System.out.println("que = " + que);
        System.out.println("poll(): " + que.poll());
        System.out.println("que = " + que);
        System.out.println("poll(): " + que.poll());
        System.out.println("que = " + que);
        System.out.println("poll(): " + que.poll());
        System.out.println("que = " + que);
        System.out.println("poll(): " + que.poll());
        System.out.println("que = " + que);
        System.out.println("poll(): " + que.poll());
        System.out.println("que = " + que);
    }
}
