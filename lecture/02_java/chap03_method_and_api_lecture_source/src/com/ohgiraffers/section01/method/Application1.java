package com.ohgiraffers.section01.method;

public class Application1 {
    // static -> java 입장에서 처음부터 인식이 가능한 상태
    // (메모리에 올라간 상태, 프로그램시작시에 메모리에 할당, 종료시까지 메모리 할당유지)
    // FILO or LIFO 구조 (Stack 구조)
    public static void main(String[] args) {
        /* 수업목표. 메소드의 호출 흐름에 대해 이해할 수 있다. */
        System.out.println("main() 시작함...");
        methodA();
        System.out.println("main() 종료함...");
    }

    public static void methodA(){
        System.out.println("methodA() 호출됨...");
        methodB();
        System.out.println("methodA() 종료됨...");
    }

    public static void methodB(){
        System.out.println("methodB() 호출됨...");
        System.out.println("methodB() 종료됨...");
    }
}
