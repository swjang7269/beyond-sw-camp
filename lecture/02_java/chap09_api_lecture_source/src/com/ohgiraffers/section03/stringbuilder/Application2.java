package com.ohgiraffers.section03.stringbuilder;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표. StringBuilder의 자주 사용되는 메소드의 용법 및 원리를 이해할 수 있다. */
        StringBuilder sb = new StringBuilder("javamariaDB");
//        StringBuffer sb = new StringBuffer("javamariaDB");        // 메소드 차이는 없지만 동시성 제어를 위한
        // 작업으로 속도가 다소 느림

        /* 설명.
         *  delete(): 시작 인덱스와 종료 인덱스를 사용해서 문자열에서 원하는 문자열 부분 제거
         *  deleteCharAt(): 문자열 인덱스를 이용해서 문자 하나를 제거한다.
         * */
        System.out.println("delete(): " + sb.delete(2, 5));
        System.out.println("deleteCharAt(): " + sb.deleteCharAt(2));

        /* 설명.
         *  insert(): 인자로 전달된 값을 문자열로 변환 후 지정된 인덱스 위치에 추가한다.
         * */
        System.out.println("insert(): " + sb.insert(1, "vao"));
        System.out.println("insert(): " + sb.insert(0, "j"));
        System.out.println("insert(): " + sb.insert(sb.length(), "jdbc"));

        /* 설명.
         *  reverse(): 문자열 인덱스 순번을 역순으로 재배열한다.
         * */
        System.out.println("reverse(): " + sb.reverse());
    }
}
