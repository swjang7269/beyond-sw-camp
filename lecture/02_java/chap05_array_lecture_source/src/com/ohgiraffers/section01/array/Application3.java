package com.ohgiraffers.section01.array;

import java.util.Arrays;

public class Application3 {
    public static void main(String[] args) {


        /* 수업목표. 배열에 초기화 되는 자료형별 기본값을 이해라 수 있다. */
        /* 설명.
         *   값의 형태별 기본값
         *   정수: 0
         *   실수: 0.0
         *   논리: false
         *   문자: \u0000
         *   참조: null    ex.String[] sArr = new String[5]
         * */

        /* 설명. 선언과 동시에 크기 할당 및 초기화 */
        int[] iArr = {11, 12, 13, 14, 15};
        int[] iArr2 = new int[]{10, 20, 30, 40, 50};    // new int[]는 생략 가능하지만 자동으로 할당 못할경우 해줘야한다.

        /* 설명. new 생성자를 행략하면 안되는 경우*/
//        test({10,20,30,40,50});           주소값이 아닌 배열 값을 넘기려하니 에러
//        test(new int[]{10,20,30,40,50});  선언과 동시에 크기 할당후 배열값 초기하 -> 주소 넘김

        /* 설명. 1. 단순 for문 */   // arr.length -> arr의 길이
        for (int i = 0; i < iArr.length; i++) {

        }

        /* 설명. 2. 향상된 for문 (foreach) -> 받아낼 변수를 활용해 처음부터 끝까지 순회 */
        //int num이 iArr을 순회하며 값을 받음 (전체순회하는 경우 사용)
        for (int num : iArr){
            System.out.println(num);
        }

        /* 설명. 3. 단순 출력문 Arrays.toString */
        System.out.println(iArr);
        test(iArr);
    }

    public static void test(int[] arr){    // 주소값을 받은 매개변수다. 배열의 값 자체를 전달받는 것이 아니다.
        System.out.println(arr);    // 얉은 복사가 일어나는것이라 동일 주소가 출력된다.
    }
}
