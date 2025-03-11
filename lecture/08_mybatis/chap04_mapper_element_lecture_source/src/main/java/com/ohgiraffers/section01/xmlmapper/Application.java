package com.ohgiraffers.section01.xmlmapper;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ElementService elementService = new ElementService();

        do {
            System.out.println("===== <resultMap> test menu =====");
            System.out.println("1. <resultMap> Test");
            System.out.println("2. <association> Test");
            System.out.println("3. <collection> Test");
            System.out.print("메뉴 번호 입력: ");
            int no = sc.nextInt();
            switch (no) {
                case 1:
                    elementService.selectResultMapTest();
                    break;
                case 2:
                    elementService.selectResultMapAssociationTest();
                    break;
                case 3:

                    break;
            }
        } while (true);
    }
}
