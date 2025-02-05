package com.ohgiraffers.section02.string;

public class Application4 {
    public static void main(String[] args) {

        /* 수업목표. 이스케이프(escape)문자 활용 및 printf를 활용할 수 있다. */
        /* 설명.
         *  이스케이프(escape) 문자
         *   문자열 혹은 문자 내에서 사용하는 특수 기능을 위한 문자이다.
         *
         * 설명.
         *  \n: 개행
         *  \t: 탭
         *  \': 작은 따옴표
         *  \": 큰 따옴표
         *  \\: 역슬래쉬 표기
         * */

        System.out.println("안녕하세요.\n저는 홍길동입니다.");
        System.out.println("안녕하세요.\t\t저는 홍길동입니다.");
        System.out.println("안녕하세요. 저는 '홍길동'입니다.");
        System.out.println('\'');
        System.out.println("역슬래쉬(\\)입니다.");

        /* 설명. 이스케이프 문자 외에도 printf관련 문법도 있으니 참고하자. */
        System.out.printf("원주율은 %.2f입니다. 우린 %d로 하죠", 2.146592, 3);
    }
}
