package com.ohgiraffers.section01.conditional;

import java.util.Scanner;

public class A_if {
    public void testSimpleIfStatement() {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수 한 개를 입력하세요: ");
        int input = sc.nextInt();

        // 만약에(입력받은 값이 짝수면) {
        //    "짝수입니다."를 출력
        // }
        if (input == 0) {
            System.out.println("0 입니다.");
        } else if (input % 2 == 1) {
            System.out.println("홀수 입니다.");
        } else {
            System.out.println("짝수 입니다.");
        }
    }

    public void testNestedIfStatement() {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수 한 개를 입력하세요: ");
        int input = sc.nextInt();

        if (input > 0) {
            if (input % 2 == 0) {
                System.out.println("양수인 짝수 입니다.");
            }
        } else if (input == 0) {
            System.out.println("0 입니다.");
        } else {
            System.out.println("음수 입니다.");
        }

        if (input > 0 && input % 2 == 0) {
            System.out.println("양수인 짝수");
        }
    }
}
