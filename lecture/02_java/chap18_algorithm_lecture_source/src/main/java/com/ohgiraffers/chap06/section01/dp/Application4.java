package com.ohgiraffers.chap06.section01.dp;

import java.io.*;
import java.util.StringTokenizer;

public class Application4 {
    public static BufferedReader toBufferedReader(String str) {
        // str에 getBytes()를 사용(개행문자를 구분하기 위해 '/n') 후 ByteArrayInputStream을 붙이고
        // InputStreamReader를 붙이고(reader 계열로 전환) BufferedReader를 붙여 readLine()을 쓸수 있도록 만듬
        InputStream is = new ByteArrayInputStream(str.getBytes());

        return new BufferedReader(new InputStreamReader(is));
    }

    public static int solution(String input) throws IOException {
        BufferedReader br = toBufferedReader(input);

        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n + 1][n + 1]; // 누적값을 담을 배열
        int[][] p = new int[n + 1][n + 1];  // 입력값이 담을 배열   필요한가?

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                /* 설명. dp배열의 한층 위의 좌상단/우상단 값 중 큰 값과 자신의 값을 더한다. */
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + dp[i][j];
            }
        }

        /* 설명. 마지막 층(n층)에 있는 1차원 배열에서 가장 큰 값 추출 */
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result = Math.max(result, dp[n][i]);
        }

        return result;
    }
}
