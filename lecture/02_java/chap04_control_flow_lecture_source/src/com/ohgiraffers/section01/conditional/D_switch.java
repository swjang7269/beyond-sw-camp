package com.ohgiraffers.section01.conditional;

import java.util.Scanner;

public class D_switch {
    public static void testSimpleSwitchStatement() {
        Scanner sc = new Scanner(System.in);
        System.out.print("등급을 입력하세요(G, S, B): ");
        // charAt(index) String에서 index에 해당하는 문자 하나 추출
        char grade = sc.next().charAt(0);

        int point = 0;

        /* 설명. true나 false 상황을 저장해서 나중에 활용할 용도로 flag 변수를 추가할 수 있다. */
        boolean flag = true;

        switch (grade) {
            case 'G':
                point += 10;
            case 'S':
                point += 10;
            case 'B':
                point += 10;
                break;
            default:
                flag = false;
                System.out.println("거 잘 좀 입력하쇼.");
        }
        /* 설명. if문에서 실행 구문이 하나일 땐 생략 가능 */
        if (flag) {
            System.out.println("당신의 등급은 " + grade + "이고, 현재 포인트는 " + point + "입니다.");
        } else {
            System.out.println("회원가입이나 하쇼.");
        }
    }
}
