package com.ohgiraffers.section08.uses;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        MemberService manager = new MemberService();
        while(true){
            System.out.println("===== 회원 관리 프로그램 =====");
            System.out.println("1. 회원 등록");
            System.out.println("2. 회원 전체 조회");
            System.out.println("9. 프로그램 종료");
            System.out.print("메뉴 선택: ");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    manager.signUpMembers();
                    break;
                case 2:
                    manager.showAllMembers();
                    break;
                case 9:
                    System.out.println("프로그램을 종료하겠습니다.");
                    return;
                default:
                    System.out.println("잘몬된 번호를 입력하였습니다.");
            }
        }
    }
}
