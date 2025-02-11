package com.ohgiraffers.section02.run;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Application2 {
    public static void main(String[] args) {
        /* 수업목표. LinkedHashSet에 대해 이해하고 활용할 수 있다. */
        /* 설명.
         *  LinkedHashSet은 저장 당시의 순서를 유지하는 특성을 가지고 있다.
         *  (중복 제거 + 순서 유지)
         */

        // 사용자가 넣어준 순서대로 저장한다.
        Set<String> lSet = new LinkedHashSet<String>();
        lSet.add("apsara");
        lSet.add("devi");
        lSet.add("shakti");
        lSet.add("adrestia");
        lSet.add("bloody");
        System.out.println("lSet = " + lSet);

        Iterator<String> iter = lSet.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
