package com.ohgiraffers.section01.array;

import java.util.Arrays;

public class Application2 {
    public static void main(String[] args) {
        /* 수업목표. 배열의 사용방법을 익혀 배열을 사용할 수 있다. */
        /* 설명.
        *   배열의 사용방법
        *   1. 배열의 선언
        *   2. 배열의 크기 할당
        *   3. 배열의 인덱스 공간에 값 대입
        * */

        int[] iArr;
        char cArr[];    // 대괄호의 위치는 변수명 뒤에 적어도 성립하나 지양하자

        iArr = new int[5];  // 0~4까지의 인덱스로 각 칸을 구분
        cArr = new char[5]; // char 기본형 \u0000
        System.out.println("iArr = " + iArr);
        System.out.println("cArr = " + Arrays.toString(cArr));

        System.out.println("주소를 10진수로 = " + iArr.hashCode());   // 객체 생성시 할당하는 고유 번호 동일 객체인지 확인하는 용도
        cArr = null;
        System.out.println("cArr = " + cArr);

        // 자바의 특징
        // 주소값을 직접 다룰 수 없다.
        // Garbage Collector 활용 -> heap영역에서 접근이 없는 값들은 old영역으로 이동, garbage collector가 비움
        // 주기적으로 안쓰는 것들을 메모리에서 정리함
    }
}
