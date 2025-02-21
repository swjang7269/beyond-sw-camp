package com.ohgiraffers.section01.insert;

/* 설명
 *  Service 계층과 Repository(DAO(Data Access Object)) 계층을 구분하고 XML 파일에서부터 쿼리를 불러와서 insert 해보기
 */

import java.lang.reflect.Member;
import java.util.Scanner;

public class Application2 {
    /* 설명. view이자 controller개념(입력받은 데이터로 하나의 Menu 객체로 만들기)*/
    public static void main(String[] args) {
        // controller: 입력 받은 데이터를 하나의 덩어리(데이터 처리에 알맞도록)로 가공처리
        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴의 이름: ");
        String menuName = sc.nextLine();

        System.out.print("메뉴의 가격: ");
        int menuPrice = sc.nextInt();

        System.out.print("카테고리 코드: ");
        int categoryCode = sc.nextInt();
        System.out.print("판매 상태: ");
        sc.nextLine();
        String orderableStatus = sc.nextLine();

        // 입력받은 값을 하나의 객체로 가공 -> 데이터 전송 및 처리가 용이하도록
        Menu menu = new Menu(menuName, menuPrice, categoryCode, orderableStatus);

        MenuService service = new MenuService();
        service.registMenu(menu);
    }
}
