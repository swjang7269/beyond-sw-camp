package com.ohgiraffers.section01.array;

import java.util.Arrays;
import java.util.Scanner;

public class Application4 {
    public static void main(String[] args) {
        /* 수업목표. 배열을 사용하는 예시를 이해하고 작성할 수 있다. */
        int[] score = new int[5];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < score.length; i++) {
            System.out.print((i + 1) + "번째 학생의 점수를 입력하세요: ");
            score[i] = sc.nextInt();
        }
        System.out.println("현재까지 입력된 값: " + Arrays.toString(score));

        /* 설명. 합계(sum) 구하기 */
        int sum = 0;
        for(int perScore : score) {
            sum += perScore;
        }
        System.out.println("sum = " + sum);

        /* 설명. 평균(avg) 구하기 */
        double avg = sum / score.length;
        System.out.println("avg = " + avg);
    }
}
