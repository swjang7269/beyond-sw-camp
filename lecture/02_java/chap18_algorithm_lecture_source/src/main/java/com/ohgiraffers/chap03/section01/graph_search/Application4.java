package com.ohgiraffers.chap03.section01.graph_search;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Application4 {
    static int node, edge;
    static int startNode;

    static int[][] map;

    /* 설명. 양방향이므로 1차원 배열의 visit 배열 */
    static boolean[] visit;

    static Queue<Integer> q = new LinkedList<>();

    static StringBuilder sb = new StringBuilder();

    public static BufferedReader toBufferedReader(String str) {
        // str에 getBytes()를 사용(개행문자를 구분하기 위해 '/n') 후 ByteArrayInputStream을 붙이고
        // InputStreamReader를 붙이고(reader 계열로 전환) BufferedReader를 붙여 readLine()을 쓸수 있도록 만듬
        InputStream is = new ByteArrayInputStream(str.getBytes());

        return new BufferedReader(new InputStreamReader(is));
    }

    public static String solution(String input) throws IOException {
        BufferedReader br = toBufferedReader(input);
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        startNode = Integer.parseInt(st.nextToken());

//        sb.delete(0, sb.length());
        sb.setLength(0);    // StringBuilder 초기화(테스트 케이스 반복 수행을 위함)
        map = new int[node + 1][node + 1];
        visit = new boolean[node + 1];

        for (int i = 1; i <= edge; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = map[b][a] = 1;
        }

        dfs(startNode);
        sb.append("\n");

        /* 설명. dfs 이후 새로운 방문 배열 할당 */
        visit = new boolean[node + 1];  // 초기화
        bfs(startNode);

        return sb.toString();
    }

    private static void dfs(int startNode) {
        visit[startNode] = true;
        sb.append(startNode + " ");

        for (int i = 1; i <= node; i++) {
            if(!visit[i] && map[startNode][i] == 1){
                dfs(i);
            }
        }
    }

    private static void bfs(int startNode) {
        visit[startNode] = true;    // 최초 호출 시에만 작동
        q.offer(startNode);

        while(!q.isEmpty()){
            startNode = q.poll();
            sb.append(startNode + " ");

            for(int i = 1; i <= node; i++){
                if(!visit[i] && map[startNode][i] == 1) {
                    q.offer(i);
                    visit[i] = true;    // 큐에 등록하는 경우(방문) true
                }
            }
        }
    }
}
