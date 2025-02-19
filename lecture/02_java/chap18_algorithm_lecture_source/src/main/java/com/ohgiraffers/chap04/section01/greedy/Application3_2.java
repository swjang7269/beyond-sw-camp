package com.ohgiraffers.chap04.section01.greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Application3_2 {
    public static BufferedReader toBufferedReader(String str) {
        // str에 getBytes()를 사용(개행문자를 구분하기 위해 '/n') 후 ByteArrayInputStream을 붙이고
        // InputStreamReader를 붙이고(reader 계열로 전환) BufferedReader를 붙여 readLine()을 쓸수 있도록 만듬
        InputStream is = new ByteArrayInputStream(str.getBytes());

        return new BufferedReader(new InputStreamReader(is));
    }

    public static int solution(String input) throws IOException {
        BufferedReader br = toBufferedReader(input);

        int N = Integer.parseInt(br.readLine());
        ArrayList<Time> timeList = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());  // 시작 시간
            int end = Integer.parseInt(st.nextToken());  // 종료 시간
            timeList.add(new Time(start, end));
        }

        int max_count = 0;
        Collections.sort(timeList);

        int endTime = 0;
        for(Time dis : timeList) {
            if(dis.start >= endTime){
//                if(dis.start == dis.end){
//                    max_count++;
//                    continue;
//                }
                endTime = dis.end;
                max_count++;
            }
        }



        return max_count;
    }
}

class Time implements Comparable<Time> {
    public int start, end;
    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Time o){
        if(this.end == o.end) {
            if (o.start == o.end)   // 시작 시간과 종료 시간이 같은 경우는 맨 뒤로
                return this.start - o.start;
            return o.start - this.start;
        }   // 종료 시간 같으면 시작 시간 내림차순
        else
            return this.end - o.end;    // 종료 시간 오름차순으로
    }
}