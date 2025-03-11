package com.ohgiraffers.section01.xml;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("===== MyBatis Dynamic Sql Query =====");
            System.out.println("1. if 확인");
            System.out.println("2. choose(when, otherwises) 확인");
            System.out.println("3. foreach 확인");
            System.out.println("4. trim(where, set) 확인");
            System.out.println("9. 종료");
            System.out.print("메뉴를 선택하세요: ");
            int no = sc.nextInt();
            switch(no) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("번호를 다시 입력하세요.");
            }
        } while(true);
    }
}
