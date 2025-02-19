package com.ohgiraffers.chap05.section01.tree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* 수업목표. 트리(Tree) 알고리즘을 활용하는 예제를 이해할 수 있다. */
/* 설명
 *  그래프에서 계층적인 구조를 나타내기 위해 최상위 노드인 루트(root) 노드에서 시작하여
 *  하위 노드들로 분기하는 방식으로 구성된 알고리즘이다.(일반적으로 이진트리만 다루게 된다.)
 */


public class Application1 {

    static int N;                   // 노드 개수
    static int[] parent;            // 부모 노드 저장 배열
    static boolean[] isVisit;       // 방문 여부 저장 배열
    static StringTokenizer st;
    static List<Integer>[] list;    // input을 받을 List

    static StringBuilder sb = new StringBuilder();  // 결과 출력을 위한 빌더

    public static BufferedReader toBufferedReader(String str) {
        // str에 getBytes()를 사용(개행문자를 구분하기 위해 '/n') 후 ByteArrayInputStream을 붙이고
        // InputStreamReader를 붙이고(reader 계열로 전환) BufferedReader를 붙여 readLine()을 쓸수 있도록 만듬
        InputStream is = new ByteArrayInputStream(str.getBytes());

        return new BufferedReader(new InputStreamReader(is));
    }

    public static String solution(String input) throws IOException {
        BufferedReader br = toBufferedReader(input);
        sb.setLength(0);    // 초기화

        N = Integer.parseInt(br.readLine());

        isVisit = new boolean[N + 1];   // 인덱스와 노드 번호 일치를 위한 +1
        list = new ArrayList[N + 1];
        parent = new int[N + 1];

        /* 설명. 각가의 노드들이 자식 정보를 담을 ArrayList를 하나씩 가지도록 초기화 */
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();

        }

        /* 설명. N-1개 줄에 걸쳐서 각 노드들 정보 입력 */
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);     // a 노드의 자식 리스트에 b를 추가
            list[b].add(a);     // 트리의 방향이 지정되지 않았기에
        }

        int root = 1;
        dfs(root);

        // 2번 노드부터 출력하도록 하였기에
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i] + " ");
        }

        return sb.toString();
    }

    private static void dfs(int node) {
        isVisit[node] = true;
        // 해당 node의 자식을 탐색
        for(int i : list[node]) {
            if(!isVisit[i]) {
                parent[i] = node;
                dfs(i);
            }
        }
    }
}
