package com.ohgiraffers.section01.xmlconfig;

import java.util.List;
import java.util.Map;

public class MenuController {
    private final MenuService menuService;
    private final PrintResult printResult;

    public MenuController() {
        menuService = new MenuService();
        printResult = new PrintResult();    // 응답 출력 페이지 (view 역할)
    }

    public void findAllMenus() {
        List<MenuDTO> menuList = menuService.findAllMenus();

//        System.out.println("Controller에서 출력");
//        menuList.forEach(System.out::println);

        // 쿼리문 수행 성공/실패 여부는 null이 아니라 isEmpty()로 확인해야 한다.
        // 수행에 실패하더라도 빈 리스트를 반환하기 때문

        if(!menuList.isEmpty()) {   // 조회 성공
            printResult.printMenus(menuList);
        } else {                    // 조회 실패
            printResult.printErrorMessage("전체 메뉴 조회 실패");
        }

    }

    public void findMenuByMenuCode(Map<String, String> parameter) {
        int menuCode = Integer.parseInt(parameter.get("menuCode")); // 웹상에서 컨트롤러에게 parameter가 전달되면 service에 전달하기 전에 가공
        MenuDTO menu = menuService.findMenuByMenuCode(menuCode);

        if(menu != null) {
            printResult.printMenu(menu);
        } else {
            printResult.printErrorMessage(menuCode + "번 메뉴는 없습니다.");
        }

    }

    public void registMenu(Map<String, String> parameter) {
        String menuName = parameter.get("menuName");
        int menuPrice = Integer.parseInt(parameter.get("menuPrice"));
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

        MenuDTO menu = new MenuDTO();
        menu.setMenuName(menuName);
        menu.setMenuPrice(menuPrice);
        menu.setCategoryCode(categoryCode);

        // 결과를 boolean으로 반환
        if(menuService.registMenu(menu)){
            printResult.printSuccessMessage("regist");
        } else {
            printResult.printErrorMessage("메뉴 추가 실패");
        }

    }

    public void modifyMenu(Map<String, String> parameter) {
        int menuCode = Integer.parseInt(parameter.get("menuCode"));
        String menuName = parameter.get("menuName");
        int menuPrice = Integer.parseInt(parameter.get("menuPrice"));

        MenuDTO menu = new MenuDTO();
        menu.setMenuCode(menuCode);
        menu.setMenuName(menuName);
        menu.setMenuPrice(menuPrice);

        if(menuService.modifyMenu(menu)){
            printResult.printSuccessMessage("modify");
        } else {
            printResult.printErrorMessage("메뉴 수정 실패");
        }
    }

    public void removeMenu(Map<String, String> parameter) {
        int menuCode = Integer.parseInt(parameter.get("menuCode"));

        if(menuService.removeMenu(menuCode)){
            printResult.printSuccessMessage("remove");
        } else {
            printResult.printErrorMessage("메뉴 삭제 실패");
        }
    }
}
