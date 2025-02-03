package com.ohgiraffers.section01.method;

public class Application2 {
    public static void main(String[] args) {
        System.out.println("main() 시작됨...");

        Application2 app = new Application2(); // new 연산자로 인스턴스(객체) 생성 (메모리에 등록)

        // 생성한 인스턴스 내의 함수 호출
        app.methodA();
        app.methodB();

        System.out.println("main() 종료됨...");
    }

    public void methodA(){
        System.out.println("methodA() 호출됨...");
        System.out.println("methodA() 종료됨...");
    }

    public void methodB(){
        System.out.println("methodB() 호출됨...");
        System.out.println("methodB() 종료됨...");
    }
}
