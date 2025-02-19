package com.ohgiraffers.chap06.section01.dp;

public class Application2 {
// dp[1] = 1, dp[2] = 2, dp[3] = 3 dp[4] = 5

    public static void main(String[] args) {
        System.out.println(solution(3));
    }

    public static int solution(int N){
        int[] dp = new int[N + 1];
        if(N >= 1) dp[1] = 1;
        if(N >= 2) dp[2] = 2;

        if(N >= 3) {
            for (int i = 3; i <= N; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }

        return dp[N];
    }
}
