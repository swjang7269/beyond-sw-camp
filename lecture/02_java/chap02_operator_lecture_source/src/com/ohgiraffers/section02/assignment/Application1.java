package com.ohgiraffers.section02.assignment;

public class Application1 {
    public static void main(String[] args) {
        /* 수업목표. 복합대입 연산자를 이해하고 활용할 수 있다. */
        /* 설명.
         *   대입연산자와 산술 복합 대입 연산자
         *   '=', '*=', '-=', '/=', '%=', '+=' */

        int num = 12;
        System.out.println("num = " + num); // 12

        num = num + 3;
        System.out.println("num = " + num); // 15

        num += 3;
        System.out.println("num = " + num); // 18

        num -= 3;
        System.out.println("num = " + num); // 15

        num += 2;
        System.out.println("num = " + num); // 30

        num /= 2;
        System.out.println("num = " + num); // 15

        num %= 2;
        System.out.println("num = " + num); // 1

        num =- 5;
        System.out.println("num = " + num); // -5
    }
}
