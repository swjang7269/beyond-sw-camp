package com.ohgiraffers.chap03.section01.graph_search;

import java.io.*;
import java.util.StringTokenizer;

public class Application1 {

    static boolean[] visit;     // 방문 배열
    static int[][] map;         // 그래프를 2차원 배열로 매핑(인접 리스트)
    static int count = 0;       // 결과값(오염된 컴퓨터의 수)
    static int node, edge;      // node와 edge

    /* 설명. 문자열에서 한 줄씩 읽어들이기 위한 BufferedReader를 반환하는 메소드(readLine())을 재사용을 위한 모듈화 */
    public static BufferedReader toBufferedReader(String str) {
        // str에 getBytes()를 사용(개행문자를 구분하기 위해 '/n') 후 ByteArrayInputStream을 붙이고
        // InputStreamReader를 붙이고(reader 계열로 전환) BufferedReader를 붙여 readLine()을 쓸수 있도록 만듬
        InputStream is = new ByteArrayInputStream(str.getBytes());

        return new BufferedReader(new InputStreamReader(is));
    }


    public static Integer solution(String input) throws IOException {
        BufferedReader br = toBufferedReader(input);
        node = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());

        /* 설명. 노드와 엣지에 대한 정보가 담긴 map(node의 갯수와 번호에 기반한 int형 2차원 배열) */
        map = new int[node + 1][node + 1];  // 인덱스와 노드 번호 일치를 위한 + 1 (0번 인덱스는 사용하지 않는다.)

        /* 설명. 방문 배열(지나갔던 노드를 재방문하지 않기 위함, 재귀 호출의 stackoverflow를 방지) */
        visit = new boolean[node + 1];      // 방문 배열도 노드 번호와 인덱스 번호 일치

        /* 설명. 인접리스트에 그래프 정보 작성 */
        // 엣지 정보를 읽어와 매핑
        for (int i = 0; i < edge; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");   // 한 줄을 읽고 구분자는 " "이다.(delim이 띄어쓰기라면 생략 가능)
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            /* 설명. 무방향(양방향) 그래프로 처리하기 위해 노드 번호(인덱스)를 반대로도 적용 */
            map[a][b] = map[b][a] = 1;      // 양방향 그래프
        }

        /* 설명. map에 그래프 정보가 입력된 것을 확인하기 위한 출력 */
//        for (int i = 0; i < node + 1; i++) {
//            for (int j = 0; j < node + 1; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

        // 1번 노드부터 시작하는 dfs(오염이 1번부터 시작된다.)
        dfs(1);

        return count - 1;   // 오염 시작 노드는 제외(-1) (1번 컴퓨터를 통해 오염된 수)
    }

    /* 설명. 재귀함수로 dfs 알고리즘을 구현할 메소드 */
    private static void dfs(int startNode) {
        visit[startNode] = true;
        count++;

        for (int i = 1; i <= node; i++) {
            if(map[startNode][i] == 1 && !visit[i]) {    // startNode와 연결되어 있고 방문하지 않았다면
                dfs(i);     // 해당 노드를 방문
            }
        }
    }
}
