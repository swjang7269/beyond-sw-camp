package com.ohgiraffers.section02.looping;

import java.util.Scanner;

public class D_doWhile {
    /* 설명. do-while은 일단 한번은 실행하고 조건에 따라 반복 */
    /* 설명. do-while은 사용자 입력 또는 선택 등을 요구할 때 주로 사용 */
    /* 설명. 메뉴 드리븐한 코드에 주로 사용 */
    public void testSimpleDoWhileStatement() {
        do {
            System.out.println("doWhile");
        } while (false);
    }

    public void testDoWhileExample() {
        int sumPrice = 0;
        Scanner sc = new Scanner(System.in);

        int choice = 0;
        do {
            System.out.println("sumPrice에 담을래 뺼래");
            System.out.println("1. 담을래(+1000");
            System.out.println("2. 뺄래(-1000)");
            System.out.println("3. 나갈래");
            System.out.print("번호를 고르시오: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    sumPrice += 1000;
                    break;
                case 2:
                    sumPrice -= 1000;
                    break;
            }
            System.out.println("현재 sumPrice: " + sumPrice);
        } while (choice < 3);
    }
}
