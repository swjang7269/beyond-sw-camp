package com.ohgiraffers.chap03.section01.graph_search;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Application2 {
    /* 설명. BFS로 문제 해결을 하기 위한 Queue */
    static Queue<Node> q = new LinkedList<>();

    // 상하좌우 탐색을 위한 배열
    /* 설명. 같은 인덱스에 있는 값을 활용한 상하좌우를 의미하는 좌표 배열 */
    static int[] dirx = {0, 0, -1, 1};
    static int[] diry = {-1, 1, 0, 0};

    /* 설명. 배추밭 */
    static int map[][];

    /* 설명. 방문 배열 */
    static boolean visit[][];   // 양방향 그래프(y = x 대칭이 아니기 때문에) 2차원 배열로 저장

    /* 설명. 현재 위치에 대한 좌표 */
    static int cur_x, cur_y;

    /* 설명. 배추밭의 크기(너비/높이), 심어진 배추의 수 */
    static int M, N, K;

    // 클래스 내에 또 클래스 생성 가능 - inner class(내부 클래스)
    /* 설명. x와 y좌표를 가지는 static 내부 클래스(배추 객체를 위한) */
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /* 설명. 필요한 배추흰지렁이의 수 */
    public static int count = 0;

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

        M = Integer.parseInt(st.nextToken());   // 너비, 가로, 열
        N = Integer.parseInt(st.nextToken());   // 높이, 세로, 행
        K = Integer.parseInt(st.nextToken());   // 배추 갯수

        /* 설명. 주어진 그림 그대로 표현하고 싶다면 x와 y의 위치를 바꾸어야 한다. (좌표와 행렬의 인덱스 개념은 반대이기 때문에 순서 유의) */
//        map = new int[N][M];    // 순서 유의
//        visit = new boolean[N][M];
//
//        for (int i = 0; i < K; i++) {
//            st = new StringTokenizer(br.readLine());
//            int x = Integer.parseInt(st.nextToken());
//            int y = Integer.parseInt(st.nextToken());
//            map[y][x] = 1;  // 좌표와 행렬의 인덱스 개념은 반대
//        }
//
//        count = 0;  // 지렁이 수 초기화
//
//        /* 설명. i와 j는 현재 좌표를 뜻하며 이중 반복을 통해 조회 */
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                /* 설명. 방문 안한 위치에 배추가 심어져 있으면 지렁이를 뿌리자(count++) */
//                if (visit[i][j] == false && map[i][j] == 1) {
//                    count++;
//
//                    bfs(j, i);  // 상하좌우를 탐색하며 배추가 주변에 있는지 탐색
//                }
//            }
//        }

        // /////////////////////////////////////////// 행열 뒤집힌채로 해도 값은 같지 않나
        count = 0;  // 테스트 케이스가 여러개이므로 count 초기화
        map = new int[M][N];
        visit = new boolean[M][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (visit[i][j] == false && map[i][j] == 1) {
                    count++;

                    bfs(i, j);
                }
            }
        }

        return count;
    }

    /* 설명. 상하좌우를 보고 방문하지 않고 유효한 범위 안에 또다른 배추가 심어져 있는지 확인(방문배열 체크) */
    private static void bfs(int x, int y) {
        q.offer(new Node(x, y));
        visit[x][y] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            /* 설명. queue에서 뽑은 배추가 상하좌우를 둘러보는 로직 */
            for (int i = 0; i < 4; i++) {
                cur_x = node.x + dirx[i];
                cur_y = node.y + diry[i];

                /* 설명. 지금 보는 방향이 좌표로써 유효하고 방문한 적이 없고 배추가 심어져 있다면(방문 체크 + queue 등록) */
                if(range_check(cur_x, cur_y) && !visit[cur_x][cur_y] && map[cur_x][cur_y] == 1){
                    visit[cur_x][cur_y] = true;
                    q.offer(new Node(cur_x, cur_y));
                }
            }
        }
    }

    /* 설명. 지금 보는 위치(cur_x, cur_y)가 배추밭 범위 안인지 체크하는 유효성 검사 메소드 */
    private static boolean range_check(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N;
    }
}
