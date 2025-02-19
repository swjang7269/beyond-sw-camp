package com.ohgiraffers.chap06.section01.dp;

/* 수업목표. 동적 계획법(Dynamic Programming) 알고리즘을 활용하는 예제를 이해할 수 있다. */

/* 설명.
 *  복잡한 전체 문제를 작은 내부 문제에 대한 최적의 해결방안을 고안(누적)하며 해결하는 알고리즘이다.
 *  규칙이 보이는 구간들에 대한 점화식을 세워 작은 문제들을 해결하면 전체 문제의 최적의 값이 나오게 된다.
 *  (점화식: 이전에 나타난 최적의 경우를 활용할 수 있는 식, 계속 반복해서 나오는 구조)
 */
public class Application1 {
    public static int solution(Integer N) {
        int[] dp = new int[N + 1];  // 1부터 시작하도록 인덱스 번호 일치화

        if (N >= 3) dp[3] = 1;
        if (N >= 5) dp[5] = 1;

        for (int i = 6; i <= N; i++) {
            /* 설명. 5나 3으로 나눌 수 있는 경우 */
            if (i % 5 == 0) {
                dp[i] = dp[i - 5] + 1;  // 5kg 봉지 추가
            } else if (i % 3 == 0) {
                dp[i] = dp[i - 3] + 1;  // 3kg 봉지 추가
            } else {
                if (dp[i - 3] != 0 && dp[i - 5] != 0) {
                    dp[i] = Math.min(dp[i-3], dp[i-5]) + 1;
                }
            }
        }

        return dp[N] != 0 ? dp[N] : -1;
    }
}
