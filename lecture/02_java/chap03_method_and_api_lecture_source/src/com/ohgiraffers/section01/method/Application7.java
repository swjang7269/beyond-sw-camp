package com.ohgiraffers.section01.method;

public class Application7 {
    public static void main(String[] args) {
        /* 수업목표. 다른 클래스에 작성한 메소드를 활용할 수 있다. */
        Calculator calc = new Calculator(); // Calculator 클래스 인스턴스 생성

        int first = 100;

        int second = 50;

        /* 설명. 덧셈 */
        System.out.println("두 수의 합: " + calc.plus(first, second));
        /* 설명. 뺄셈 */
        System.out.println("두 수의 차: " + calc.minus(first, second));

        /* 설명. 최소값 */
        System.out.println("두 수 중 작은값: " + calc.minNumbersOf(first, second));
        /* 설명. 최대값 */
        System.out.println("두 수 중 큰 값: " + com.ohgiraffers.section01.method.Calculator.maxNumbersOf(first, second));
    }
}
