package com.ohgiraffers.section03.copy;

import java.util.Arrays;

public class Application1 {
    public static void main(String[] args) {
        /* 수업목표. 배열의 복사 개념 중 얕은 복사에 대해 이해할 수 있다. */
        /* 설명.
         *  배열의 복사에는 크게 두 가지 개념이 있다.
         *  1. 얕은 복사(shallow copy): stack의 주소 값만 복사
         *  2. 깊은 복사(deep copy): heap의 배열에 저장된 값을 복사 */

        int[] originArr = {1, 2, 3};
        int[] copyArr = originArr;  // 주소 값만 복사

        System.out.println(copyArr + " " + originArr);  // 두 배열은 동일 주소를 저장하고 있다.
        copyArr[2] = 100;
        System.out.println(Arrays.toString(originArr)); // 복사한 배열에서 값을 조작하면 원본에도 영향이 간다.

        /* 설명. 메소드를 호출해서 넘기는 전달인자가 참조 자료값(주소값)일 경우
         *   얕은 복사가 일어난다. (feat. call by reference)
         *   실제 값이 넘어오는 경우 원본에 영향을 주지 않는다. (feat. call by value)*/
        test(copyArr);  // 참조인자를 넘겨 주소만 전달
    }

    public static void test(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
