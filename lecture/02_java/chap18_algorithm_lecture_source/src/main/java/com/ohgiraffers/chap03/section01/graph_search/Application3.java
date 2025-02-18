package com.ohgiraffers.chap03.section01.graph_search;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Application3 {
    static int depth;

    static boolean[][] visit;
    static int[][] map;
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {1, -1, 0, 0};
    static int N, M;

    static class Node {
        int x;
        int y;
        int depth;

        public Node(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    /* 설명. 문자열에서 한 줄씩 읽어들이기 위한 BufferedReader를 반환하는 메소드(readLine())을 재사용을 위한 모듈화 */
    public static BufferedReader toBufferedReader(String str) {
        // str에 getBytes()를 사용(개행문자를 구분하기 위해 '/n') 후 ByteArrayInputStream을 붙이고
        // InputStreamReader를 붙이고(reader 계열로 전환) BufferedReader를 붙여 readLine()을 쓸수 있도록 만듬
        InputStream is = new ByteArrayInputStream(str.getBytes());

        return new BufferedReader(new InputStreamReader(is));
    }

    public static Integer solution(String input) throws IOException {
        BufferedReader br = toBufferedReader(input);
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];

        /* 설명. 입력값이 공백없이 이어서 들어옴에 따라 한 문자씩 뜯어서 int 배열(map)에 옮겨담는 반복문 */
//        for (int i = 0; i < N; i++) {
//            String str = br.readLine();
//            char[] chArr = str.toCharArray();     // String을 char배열로 바꾸는 메소드
//            for (int j = 0; j < M; j++) {
//                map[i][j] = Character.getNumericValue(chArr[j]);  // 문자를 매칭되는 숫자로 바꾸는 메소드
//            }
//        }
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Character.getNumericValue(str.charAt(j));   // 문자를 숫자로 바꿔줌
            }
        }

        /* 설명. 시작과 동시에 첫 번째 칸 방문 체크 */
        visit[0][0] = true;
        depth = 0;
        bfs(0, 0);      // 도착지(우하단) 위치까지 bfs가 돌아가며 알고리즘 진행

//        return map[N-1][M-1]; // 마지막 칸 까지 가는 최적의 경로 길이(depth로 map을 덮어 쓸 것)
        return depth;
    }

    private static void bfs(int n, int m) {
        Queue<Node> q = new LinkedList<Node>();
        q.offer(new Node(n, m, 1)); // 맨 처음 노드의 depth를 1로
        visit[n][m] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int cur_n = node.x + dirX[i];
                int cur_m = node.y + dirY[i];

                if(range_check(cur_n, cur_m) && !visit[cur_n][cur_m] && map[cur_n][cur_m] == 1){
                    visit[cur_n][cur_m] = true;
                    q.offer(new Node(cur_n, cur_m, node.depth + 1));    // depth 가 1층 더 깊어짐
                }

                /*
                설명. 상하 좌우를 둘러볼 때 미로 범위를 넘어가면 다른 방향을 보도록
                if(cur_n < 0 || cur_m < 0 || cur_n >= N || cur_m >= M) {
                    continue;
                }

                설명. 방문했거나 벽을 만나면
                if(visit[cur_n][cur_m] || map[cur_n][cur_m] == 0) {
                    continue;
                }

                q.offer(new Node(cur_n, cur_m));
                map[cur_n][cur_m] = map[node.y][node.x] + 1;    // 기존 노드 값보다 1 증가
                */
            }
            depth = node.depth;     // 큐에서 맨 마지막에 나온 노드의 depth가 목적지(도착지)의 depth다.
        }

    }

    private static boolean range_check(int cur_n, int cur_m) {
        return cur_n >= 0 && cur_n < N && cur_m >= 0 && cur_m < M;
    }
}
