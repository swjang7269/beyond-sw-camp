package com.ohgiraffers.section03.math;

public class Application2 {
    public static void main(String[] args) {
        /* 수업목표. 사용자 지정 범위의 난수를 발생시킬 수 있다. */
        /* 설명. 1. 0~9까지의 난수 생성 */
        System.out.println((int)(Math.random() * 10));

        /* 설명. 2. 80~100까지의 난수 생성 (100 - 79) */
        System.out.println((int)(Math.random() * 21 + 80));

        /* 설명. 3. -188~10까지의 난수 생성 (10 - (-189)) */  // 음수 188개, 0, 양수 10개
        System.out.println((int)(Math.random() * 199 - 188));
    }
}
