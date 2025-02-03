package com.ohgiraffers.section03.branching;

public class A_break {
    public static void testSimpleBreakStatement() {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
            System.out.println("i = " + i + ", sum = " + sum);
            /* 설명. break문은 가장 가까운 반복문/switch문을 종료 */
            if(sum > 100)
                break;
        }
    }
}
