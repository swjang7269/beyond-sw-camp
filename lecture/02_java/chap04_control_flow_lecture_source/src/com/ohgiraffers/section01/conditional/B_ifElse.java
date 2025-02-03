package com.ohgiraffers.section01.conditional;

import java.util.Scanner;

public class B_ifElse {
    public void testSimpleIfElseStatement() {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수를 하나 입력하세요: ");
        int input = sc.nextInt();

        /* 의사 코드 pseudo code */
//        만약에(홀수라면){
//            "홀수입니다"
//        } 그렇지 않다면{
//            "짝수입니다."
//        }
        if (input % 2 == 1) {
            System.out.println("홀수입니다.");
        } else {
            System.out.println("짝수입니다.");
        }
    }

    public void testNestedIfElseStatement() {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 하나를 입력하세요: ");
        int input = sc.nextInt();

        if (input >= 0) {
            if (input % 2 == 0) {
                System.out.println("양수인 짝수");
            } else {
                System.out.println("양수은 홀수");
            }
        } else {
            System.out.println("음수");
        }
    }
}
