package com.ohgiraffers.section02.run;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Application3 {
    public static void main(String[] args) {
        /* 수업목표. TreeSet에 대해 이해하고 활용할 수 있다. */
        /* 설명. Tree 구조를 활용해 중복 제거 + 정렬을 해준다. */

        /* 트리 구조 heapfy 알고리즘
         * depth가 낮을 수록 우선순위에 따라 정렬
         * 말단에 노드를 추가 -> 부모 노드와 우선순위 비교 -> 우선순위가 높은 것을 부모 노드로
         * -> root 노드까지 반복
         *
         * root 노드 제거 -> 바로 아래 자식 노드들 중 우선순위가 높은 값을 root로 올림
         * -> 빈 노드의 아래 자식 노드를 비교해서 우선순위가 높은 값들을 빈자리를 채워 올린다.
         */

        Set<String> tSet = new TreeSet<>();
        tSet.add("first");
        tSet.add("second");
        tSet.add("third");
        tSet.add("fourth");
        tSet.add("fifth");
        System.out.println("tSet = " + tSet);

        /* 설명. 로또 번호 발생기(feat. 보너스 번호 추출 제외)
         *  1부터 45까지 중복되지 않고 오름차순 정렬된 6개의 값 추출하기
         */
        Set<Integer> lotto = new TreeSet<>();
        while(lotto.size() < 6) {
            lotto.add((int)(Math.random()*45) + 1);
        }
        System.out.println("lotto = " + lotto);

        /* 설명. 배열을 활용한 TreeSet과 같은 기능을 하는 알고리즘 구현해 보기 */
        int[] arr = new int[6];
        System.out.println(arr);

        boolean a = false;
        for (int i = 0; i < 6; i++) {
            arr[i] = (int)(Math.random() * 45) + 1;
            for(int j=0;j<i;j++){
                if(arr[j] == arr[i]) {
                    i--;
                    break;
                }
            }
        }
        System.out.println("arr = " + Arrays.toString(arr));

        // bubble 정렬
        for(int i=0;i<6;i++){
            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[i]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        System.out.println("arr = " + Arrays.toString(arr));
    }
}
