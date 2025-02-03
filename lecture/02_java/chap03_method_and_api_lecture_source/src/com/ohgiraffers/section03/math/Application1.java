package com.ohgiraffers.section03.math;

public class Application1 {
    public static void main(String[] args) {
        /* 수업목표. Math 클래스에서 제공하는 static 메소드를 호출할 수 있다. */
//        double result = java.lang.Math.abs(-10.2);
        /* 설명. 다른 패키지에 있는 api 클래스는 import 또는 풀 클래스명을 적어야 하지만 java.lang 패키지는 생략 허용 */
        double result = Math.abs(-10);

        /* 설명. 최대값, 최소값 출력 */
        // non-static의 경우 new 생성자를 통해 생성해야 메모리에 등록
        System.out.println("10과 20중 더 작은 값: " + Math.min(10, 20));
        System.out.println("10과 20중 더 큰 값: " + Math.max(10, 20));

        /* 설명. 난수 생성 */
        System.out.println("난수 생성: " + Math.random());

    }
}
