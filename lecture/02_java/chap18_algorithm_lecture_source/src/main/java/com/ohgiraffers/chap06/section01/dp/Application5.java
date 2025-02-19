package com.ohgiraffers.chap06.section01.dp;

import java.io.*;
import java.util.StringTokenizer;

public class Application5 {
    public static BufferedReader toBufferedReader(String str) {
        // str에 getBytes()를 사용(개행문자를 구분하기 위해 '/n') 후 ByteArrayInputStream을 붙이고
        // InputStreamReader를 붙이고(reader 계열로 전환) BufferedReader를 붙여 readLine()을 쓸수 있도록 만듬
        InputStream is = new ByteArrayInputStream(str.getBytes());

        return new BufferedReader(new InputStreamReader(is));
    }

    public static int solution(String input) throws IOException {
        BufferedReader br = toBufferedReader(input);
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());    // 계단의 수
        int[] score = new int[n+1];                 // 계단에 적흰 점수

        for(int i=1;i<=n;i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n+1];
        dp[1] = score[1];
        dp[2] = score[1] + score[2];
        dp[3] = Math.max(score[1] + score[3], score[2]);    // 연달아 3칸은 불가능

        // 도착지에 도달하는 방법은 2가지가 있다.
        // 1. 이전 계단에서 한칸 오르기(이전 계단에 도달하기 직전엔 2칸을 올라왔다.) 2칸 전부터 한 칸씩 올라오는건 안된다.
        // 2. 2칸 전에서 한 번에 2칸 오르기
        for(int i=3;i<=n;i++) {
            dp[i] = Math.max(dp[i-3] + score[i-1], dp[i-2]) + score[i];    // (직전 계단을 밝고 오는 경우 vs 2칸 직전 계단에서 한 번에 오르는 경우)
        }

        return dp[n];
    }
}
