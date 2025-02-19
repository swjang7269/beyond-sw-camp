package com.ohgiraffers.chap06.section01.dp;

public class Application3 {
    // 1 <= N <= 100 이기에 크기를 101로
    public static Integer[] dp = new Integer[101];  // null을 활용하기 위하여 int가 아닌 Integer 사용

    public static int solution(int n) {
         dp[1] = 1;
         dp[2] = 1;
         dp[3] = 1;

        return padovan(n);
    }

    private static int padovan(int n) {
        /* 설명. 재귀 호출에 의한 stackoverflow를 막기 위해 null이 아닌 값을 만날 때까지만 재귀 호출 */
        if(dp[n] == null)   // stackoverflow를 막기 위함
            dp[n] = padovan(n-2) + padovan(n-3);    // 재귀 호출
        return dp[n];
    }
}
