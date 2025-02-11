package com.ohgiraffers.section04.testapp.run;

import com.ohgiraffers.section04.testapp.service.MemberService;

import java.util.Scanner;

public class Application {
    // 싱글톤으로 관리하기 위함 -> 서비스 계층은 프로그램 당 한 개만 되도록
    // 프로그램이 구동하자 마자 MemberService가 생성되어야 하며 그를 위해서는 MemberRepository가 생성되어야함
    private static final MemberService ms = new MemberService();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("====== 회원 관리 프로그램 ======");
            System.out.println("1. 모든 회원 정보 보기");
            System.out.println("2. 회원 찾기");
            System.out.println("3. 회원 가입");
            System.out.println("4. 회원 정보 수정");
            System.out.println("5. 회원 탈퇴");
            System.out.println("9. 프로그램 종료");
            System.out.print("메뉴 입력: ");
            int input = sc.nextInt();

            // 서비스 계층으로 전달
            switch (input){
                case 1:
                    ms.findAllMembers();
                    break;
                case 2:
                    ms.findMemberBy(chooseMemNo());
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 9:
                    System.out.println("회원 관리 프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("번호를 잘못 입력하셨습니다.");
            }
        }
    }

    /* 설명. 회원 번호를 입력 받아 int로 반ㅘ낳는 메소드*/
    private static int chooseMemNo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("회원 번호: ");
        return sc.nextInt();
    }
}
