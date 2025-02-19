package com.ohgiraffers.chap04.section01.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class Application2 {

    public static BufferedReader toBufferedReader(String str) {
        // str에 getBytes()를 사용(개행문자를 구분하기 위해 '/n') 후 ByteArrayInputStream을 붙이고
        // InputStreamReader를 붙이고(reader 계열로 전환) BufferedReader를 붙여 readLine()을 쓸수 있도록 만듬
        InputStream is = new ByteArrayInputStream(str.getBytes());

        return new BufferedReader(new InputStreamReader(is));
    }

    public static int solution(String input) throws IOException {
        BufferedReader br = toBufferedReader(input);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 동전 종류의 갯수
        int K = Integer.parseInt(st.nextToken());   // 금액

        int[] coin = new int[N];                    // 동전의 종류
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            coin[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;

        // 큰 금액의 동전부터 지불
        for (int i = N-1; i >= 0; i--) {
            if(K >= coin[i]) {
                count += K / coin[i];
                K %= coin[i];           // 잔액
            }
            if(K == 0)
                break;
        }

        /* 설명. 1원까지 있어 else는 고려하지 않는다. */
        return count;
    }
}
