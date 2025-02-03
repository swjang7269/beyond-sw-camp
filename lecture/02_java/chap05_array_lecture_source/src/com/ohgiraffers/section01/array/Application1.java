package com.ohgiraffers.section01.array;

import java.util.Arrays;

public class Application1 {
    public static void main(String[] args) {
        /* 수업목표. 배열에 대해 이해하고 배열의 사용 목적을 이해라 수 있다. */

        int sum = 0;

        int[] arr = new int[5];     // 자바는 쓰레기값이 아닌 기본값 즉 int의 기본값 0이 들어가 있다.
        // arr은 배열의 시작주소를 참조한다. 배열은 기본 자료형이 아니다.

        for (int i = 0; i < 5; i++) {
            arr[i] = (i + 1) * 10;
        }

        for (int i = 0; i < 5; i++) {
            sum += arr[i];
        }
        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println("sum = " + sum);
    }
}
