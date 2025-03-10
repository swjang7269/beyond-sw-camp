package com.ohgiraffers.section01.xmlconfig;

import java.util.List;

public class PrintResult {


    public void printMenus(List<MenuDTO> menuList) {
//        menuList.forEach(menu -> System.out.println(menu));
        menuList.forEach(System.out::println);
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printMenu(MenuDTO menu) {
        System.out.println("menu = " + menu);
    }

    public void printSuccessMessage(String statusCode) {
        String successMessage = "";
        switch (statusCode) {
            case "regist": successMessage = "신규 메뉴 등록 성공"; break;
            case "modify": successMessage = "메뉴 수정 성공"; break;
            case "remove": successMessage = "메뉴 삭제 성공"; break;
        }
    }
}
