package com.ohgiraffers.chap04.section01.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 설명. 람다식을 활용한 풀이 */
public class Application3_1 {

    public static BufferedReader toBufferedReader(String str) {
        // str에 getBytes()를 사용(개행문자를 구분하기 위해 '/n') 후 ByteArrayInputStream을 붙이고
        // InputStreamReader를 붙이고(reader 계열로 전환) BufferedReader를 붙여 readLine()을 쓸수 있도록 만듬
        InputStream is = new ByteArrayInputStream(str.getBytes());

        return new BufferedReader(new InputStreamReader(is));
    }

    public static int solution(String input) throws IOException {
        BufferedReader br = toBufferedReader(input);

        int N = Integer.parseInt(br.readLine());
        int[][] time = new int[N][2];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());  // 시작 시간
            time[i][1] = Integer.parseInt(st.nextToken());  // 종료 시간
        }

        // Comparator<T> 사용
        /* 설명. o1, o2는 각각의 회의를 뜻하고 두 개의 회의가 람다식에 넘어온다.(이차원 배열 내의 1차원 배열 순서가 정렬됨) */
        // 행을 기준으로 정렬 됨
        Arrays.sort(time, (o1, o2) -> {
            if (o1[1] == o2[1]) {       // 종료 시간이 같다면
                if (o2[0] == o2[1])     // 시작 시간과 종료 시간이 같다면 뒤로 보내자
                    return o1[0] - o2[0];
                return o2[0] - o1[0];   // 시작 시간은 내림차순
            }
            return o1[1] - o2[1];       // 종료 시간을 기준으로 오름차순 정렬
        });

        int max_count = 0;

        int end = 0;

        for (int i = 0; i < N; i++) {

            /* 설명 앞선 회의가 끝나는 시간 이후에 열리는 i의 회의 */
            if (end <= time[i][0]) {                             // 2 2, 1 3 이고 이전 종료 시간이 1이라면? 2 2 회의 진행되고 1 3 진행되면 문제가 생긴다?
//                if (time[i][0] == time[i][1]) {
//                    max_count++;
//                    continue;
//                }     // 정렬 기준을 바꿔 정렬되는 순서를 바꿨기에 추가적으로 조건을 걸 필요가 없어진다.
                end = time[i][1];   // 종료 시간 업데이트
                max_count++;
            }
        }


        return max_count;
    }
}
