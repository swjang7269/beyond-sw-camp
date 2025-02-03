package com.ohgiraffers.section02.looping;

import java.sql.SQLOutput;
import java.util.Scanner;

public class B_nestedFor {
    public void printGugudanFromTwo2Nine() {
//        for (int i = 2; i < 10; i++) {
//            System.out.println(i + "단");
//            for (int j = 1; j < 10; j++) {
//                System.out.println(i + " * " + j + " = " + i * j);
//            }
//            System.out.println();
//        }

        /* 기능 분리하여 모듈화 */
        for (int i = 2; i < 10; i++) {
            System.out.println(i + "단");
            printGugudanOf(i);
            System.out.println();
        }
    }

    /* 설명. 해당 단의 1~9의 곱을 출력 */
    private static void printGugudanOf(int i) {
        for (int j = 1; j < 10; j++) {
            System.out.println(i + " * " + j + " = " + i * j);
        }
    }

    public void printStars() {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 입력하시오: ");
        int input = sc.nextInt();
        for (int i = 0; i < input; i++) {
            /* 설명. 공백 찍기 */
            printSpace(input, i);
            /* 설명. 별 찍기 */
            printStar(i);
            System.out.println();
        }
    }

    private void printSpace(int input, int i) {
        for(int j = 0; j < input - i - 1; j++){
            System.out.print(" ");
        }
    }

    private void printStar(int i) {
        for(int j = 0; j < i + 1; j++){
            System.out.print("*");
        }
    }
}
