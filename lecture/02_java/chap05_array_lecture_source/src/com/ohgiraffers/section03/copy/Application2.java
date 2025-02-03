package com.ohgiraffers.section03.copy;

import java.util.Arrays;

public class Application2 {
    public static void main(String[] args) {
        /* 수업목표. 깊은 복사에 대해 이해할 수 있다. */
        /* 설명.
         *   깊은 복사를 하는 방법은 4가지가 있다.
         *   1. for문을 이용한 동일한 인덱스 값들끼리 일일이 복사
         *   2. Object의 clone()을 이용한 복사(사용 빈도 높음)
         *   3. System의 arraycopy()를 이용한 복사
         *   4. Arrays의 copyOf()를 이용한 복사
         * */
        int[] originArr = new int[]{1, 2, 3, 4};
        printArr(originArr, "원본");

        int[] shallowCopyArr = originArr;
        printArr(shallowCopyArr, "얕은 복사본");

        /* 설명. 1. for문 활용 */
        int[] copyArr1 = new int[originArr.length];
        for (int i = 0; i < originArr.length; i++) {
            copyArr1[i] = originArr[i];
        }
        printArr(copyArr1, "for문 복사본");

        /* 설명. 2. clone() 활용 */
        int[] copyArr2 = originArr.clone();
        printArr(copyArr2, "clone() 복사본");

        /* 설명. 3. System.arraycopy() 활용 -> 원본에서 일부 복사 */
        int[] copyArr3 = new int[originArr.length + 3];
        System.arraycopy(originArr, 0, copyArr3, 3, 3);
        printArr(copyArr3, "arraycopy()활용");

        /* 설명. 4. copyOf() 활용 -> 처음부터 원하는 길이만큼 복사(크기 지정 안해도 됨) */
        int[] copyArr4 = Arrays.copyOf(originArr, 2);
        printArr(copyArr4, "copyOf() 활용");
    }

    /* 설명. 배열의 주소와 설명이 넘어오면 출력하는 메소드 */
    public static void printArr(int[] arr, String desc) {
        System.out.println("=====" + desc + "=====");
        System.out.println("해당 배열의 hashCode: " + arr.hashCode());
        System.out.println(Arrays.toString(arr));
    }
}
