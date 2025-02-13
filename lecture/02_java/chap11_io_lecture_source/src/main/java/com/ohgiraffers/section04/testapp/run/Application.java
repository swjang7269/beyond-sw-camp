package com.ohgiraffers.section04.testapp.run;

import com.ohgiraffers.section04.testapp.aggregate.BloodType;
import com.ohgiraffers.section04.testapp.aggregate.Member;
import com.ohgiraffers.section04.testapp.service.MemberService;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Application {
    // 싱글톤으로 관리하기 위함 -> 서비스 계층은 프로그램 당 한 개만 되도록
    // 프로그램이 구동하자 마자 MemberService가 생성되어야 하며 그를 위해서는 MemberRepository가 생성되어야함
    private static final MemberService ms = new MemberService();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
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
            switch (input) {
                case 1:
                    ms.findAllMembers();
                    break;
                case 2:
                    ms.findMemberBy(chooseMemNo());
                    break;
                case 3:
                    ms.registMember(sign());
                    break;
                case 4:
                    Member selected = ms.findMemberForMod(chooseMemNo());
                    if (selected == null) continue;
                    ms.modifyMember(reform(selected));
                    break;
                case 5:
                    ms.removeMember(chooseMemNo());
                    break;
                case 9:
                    System.out.println("회원 관리 프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("번호를 잘못 입력하셨습니다.");
            }
        }
    }

    /* 설명. 회원 수정 페이지 */
    private static Member reform(Member modifyMember) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("===== 회원 정보 수정 서브 메뉴 =====");
            System.out.println("1. 패스워드");
            System.out.println("2. 나이");
            System.out.println("3. 취미");
            System.out.println("4. 혈액형");
            System.out.println("9. 메인 메뉴로 돌아가기");
            System.out.print("메뉴 선택: ");

            int chooseNo = sc.nextInt();
            sc.nextLine();
            switch (chooseNo) {
                case 1:
                    System.out.print("수정 후 패스워드: ");
                    modifyMember.setPwd(sc.nextLine());
                    break;
                case 2:
                    System.out.println("수정 후 나이: ");
                    modifyMember.setAge(sc.nextInt());
                    break;
                case 3:
//                    System.out.println("수정 후 취미: "); // 배열은 단순 Scanner로 입력 불가
                    modifyMember.setHobbies(resetHobbies());
                    break;
                case 4:
//                    System.out.println("수정 후 혈액형: ");
                    modifyMember.setBloodType(resetBloodType());    // enum또한 단순 Scanner로 입력 불가
                    break;
                case 9:
                    System.out.println("메인 메뉴로 돌아갑니다.");
                    return modifyMember;
                default:
                    System.out.println("번호를 다시 입력해주세요.");
            }
        }
    }

    private static BloodType resetBloodType() {
        Scanner sc = new Scanner(System.in);
        System.out.print("수정 후 혈액형(A, AB, B, O): ");
        String bloodType = sc.nextLine().toUpperCase();
        BloodType bt = null;
        switch(bloodType){
            case "A": bt = BloodType.A; break;
            case "AB": bt = BloodType.AB; break;
            case "B": bt = BloodType.B; break;
            case "O": bt = BloodType.O; break;
        }
        return bt;
    }

    private static String[] resetHobbies() {
        Scanner sc = new Scanner(System.in);
        System.out.println("수정 후 취미의 갯수(1개이상): ");
        int length = sc.nextInt();
        sc.nextLine();

        String[] hobbies = new String[length];
        for (int i = 0; i < hobbies.length; i++) {
            System.out.println((i+1)+"번째 취미 입력: ");
            String input = sc.nextLine();
            hobbies[i] = input;
        }
        return null;
    }

    /* 설명. 회원가입 시 입력할 정보를 받는 메소드 */
    /* 설명. 회원 가입 페이지 */
    private static Member sign() {
        Member member = null;

        Scanner sc = new Scanner(System.in);
        System.out.print("아이디 입력: ");
        String id = sc.nextLine();

        System.out.print("패스워드 입력: ");
        String pwd = sc.nextLine();

        System.out.print("나이 입력: ");
        int age = sc.nextInt();

        System.out.print("입력할 취미의 갯수(1개 이상): ");
        int length = sc.nextInt();
        sc.nextLine(); // 버퍼에 남은 엔터 제거용
        String[] hobbies = new String[length];
        for (int i = 0; i < hobbies.length; i++) {
            System.out.print((i + 1) + "번째 취미 입력: ");
            String input = sc.nextLine();
            hobbies[i] = input;
        }

        System.out.print("혈액형 입력(A, AB, B, O): ");
        String bloodType = sc.nextLine().toUpperCase();
        BloodType bt = null;
        switch (bloodType) {
            case "A":
                bt = BloodType.A;
                break;
            case "AB":
                bt = BloodType.AB;
                break;
            case "B":
                bt = BloodType.B;
                break;
            case "O":
                bt = BloodType.O;
                break;
        }

        member = new Member(id, pwd, age, hobbies, bt);

        return member;
    }

    /* 설명. 회원 번호를 입력 받아 int로 반ㅘ낳는 메소드*/
    private static int chooseMemNo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("회원 번호: ");
        return sc.nextInt();
    }
}
