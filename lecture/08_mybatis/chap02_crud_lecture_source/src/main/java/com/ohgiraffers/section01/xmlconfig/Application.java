package com.ohgiraffers.section01.xmlconfig;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MenuController menuController = new MenuController();   // 수동 의존성 주입
        do {
            System.out.println("===== 메뉴 관리 =====");
            System.out.println("1. 메뉴 전체 조회");
            System.out.println("2. 메뉴 코드로 메뉴 조회");
            System.out.println("3. 신규 메뉴 추가");
            System.out.println("4. 메뉴 수정");
            System.out.println("5. 메뉴 삭제");
            System.out.println("9. 프로그램 종료");
            System.out.print("메뉴 관리 번호를 입력하세요: ");
            int no = sc.nextInt();
            switch (no) {
                case 1:
                    menuController.findAllMenus();
                    break;
                case 2:
                    menuController.findMenuByMenuCode(inputMenuCode("find"));
                    break;
                case 3:
                    menuController.registMenu(inputMenu());
                    break;
                case 4:
                    menuController.modifyMenu(inputModifyMenu());
                    break;
                case 5:
                    menuController.removeMenu(inputMenuCode("remove"));
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("번호를 다시 입력하세요");
            }
        } while(true);
    }

    private static Map<String, String> inputModifyMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("수정할 메뉴의 번호: ");
        String menuCode = sc.nextLine();
        System.out.print("수정할 메뉴의 이름: ");
        String menuName = sc.nextLine();
        System.out.print("수정할 메뉴의 가격: ");
        String menuPrice = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("menuCode", menuCode);
        parameter.put("menuName", menuName);
        parameter.put("menuPrice", menuPrice);

        return parameter;
    }

    private static Map<String, String> inputMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("신규 메뉴의 이름: ");
        String menuName = sc.nextLine();
        System.out.print("신규 메뉴의 가격: ");
        String menuPrice = sc.nextLine();
        System.out.print("신규 메뉴의 카테고리: ");
        String categoryCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("menuName", menuName);
        parameter.put("menuPrice", menuPrice);
        parameter.put("categoryCode", categoryCode);

        return parameter;
    }

    /* 설명. 사용자의 입력 값을 Map<String, String> 형태로 변환(request의 parameter 개념 적용) */
    private static Map<String, String> inputMenuCode(String request) {
        Scanner sc = new Scanner(System.in);
        switch (request) {
            case "find": System.out.print("조회 할 메뉴 번호 입력: "); break;
            case "remove": System.out.print("삭제 할 메뉴 번호 입력: "); break;
        }
        String menuCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("menuCode", menuCode);

        return parameter;
    }
}
