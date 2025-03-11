package com.ohgiraffers.section01.xml;

import java.util.*;

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
                    ifSubMenu();
                    break;
                case 2:
                    chooseSubMenu();
                    break;
                case 3:
                    foreachSubMenu();
                    break;
                case 4:
                    trimSubMenu();
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("번호를 다시 입력하세요.");
            }
        } while(true);
    }

    private static void trimSubMenu() {
        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();
        do {
            System.out.println("===== trim Sub Menu =====");
            System.out.println("1. 검색 조건이 있는 경우 메뉴 코드로 조회, 단 없으면 전체 조회");
            System.out.println("2. 메뉴 혹은 카테고리로 검색, 단 메뉴와 카테고리 둘 다 일치하는 경우도 검색하며, "
                    + "검색 조건이 없는 경우 전체 조회");
            System.out.println("3. 원하는 메뉴 정보만 수정");
            System.out.println("9. 이전 메뉴로");
            System.out.print("메뉴 번호 입력: ");
            int no = sc.nextInt();
            switch(no) {
                case 1:
                    menuService.searchMenuByCodeOrSearchAll(inputAllOrOne());
                    break;
                case 2:
                    menuService.searchMenuByNameOrCategory(inputSearchCriteriaMap());
                    break;
                case 3:
                    menuService.modifyMenu(inputChangeInfo());
                    break;
                case 9:
                    return;
            }
        } while(true);
    }

    private static Map<String, Object> inputChangeInfo() {
        Scanner sc = new Scanner(System.in);

        System.out.print("변경할 메뉴 코드 입력: ");
        int menuCode = sc.nextInt();
        System.out.print("변경할 메뉴 이름: ");
        sc.nextLine();
        String menuName = sc.nextLine();
        System.out.print("변경할 판매 여부: ");
        String orderableStatus = sc.nextLine().toUpperCase();

        Map<String, Object> criteria = new HashMap<>();
        criteria.put("menuCode", menuCode);
        criteria.put("menuName", menuName);
        criteria.put("orderableStatus", orderableStatus);

        return criteria;
    }

    private static Map<String, Object> inputSearchCriteriaMap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("검색 조건 입력(category or name or both or none): ");
        String condition = sc.nextLine();

        Map<String, Object> criteria = new HashMap<>();
        if ("category".equals(condition)) {
            System.out.print("검색할 카테고리 코드 입력: ");
            int categoryCode = sc.nextInt();
            criteria.put("categoryCode", categoryCode);
        } else if ("name".equals(condition)) {
            System.out.print("검색할 이름 입력: ");
            String nameValue = sc.nextLine();
            criteria.put("nameValue", nameValue);
        } else if ("both".equals(condition)) {
            System.out.print("검색할 카테고리 코드 입력: ");
            int categoryCode = sc.nextInt();
            sc.nextLine();
            System.out.print("검색할 이름 입력: ");
            String nameValue = sc.nextLine();

            criteria.put("categoryCode", categoryCode);
            criteria.put("nameValue", nameValue);
        }

        return criteria;
    }

    private static SearchCriteria inputAllOrOne() {
        Scanner sc = new Scanner(System.in);
        System.out.print("검색 조건을 입력하시겠습니까?(y or n): ");

        boolean hasSearchValue = "y".equals(sc.nextLine());

        SearchCriteria searchCriteria = new SearchCriteria();
        if(hasSearchValue){
            System.out.print("검색할 메뉴 코드 입력: ");
            String menuCode = sc.nextLine();
            searchCriteria.setCondition("menuCode");
            searchCriteria.setValue(menuCode);
        }

        return searchCriteria;
    }

    private static void foreachSubMenu() {
        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();
        do {
            System.out.println("===== foreach Sub Menu =====");
            System.out.println("1. 랜덤 메뉴 5개 추출 ");
            System.out.println("9. 이전 메뉴로");
            System.out.print("메뉴 번호 입력: ");
            int no = sc.nextInt();
            switch(no) {
                case 1:
                    menuService.searchMenuByRandomMenuCode(generateRandomMenuCodeList());
                    break;
                case 9:
                    return;
            }
        } while(true);
    }

    /* 설명. 중복되지 않은 21개의 메뉴 5개를 랜덤하게 생성하고 정렬 후 List<Integer>로 반환 */
    private static List<Integer> generateRandomMenuCodeList() {
        Set<Integer> set = new HashSet<>();
        while(set.size() < 5) {
            int random = (int)(Math.random() * 21) + 1;
            set.add(random);
        }

        /* 설명. Hashset -> ArrayList */
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        System.out.println("생성된 난수: " + list);
        return list;
    }

    private static void chooseSubMenu() {
        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();
        do {
            System.out.println("===== choose Sub Menu =====");
            System.out.println("1. 카테고리 상위 분류로 메뉴 조회(식사, 음료, 디저트): ");
            System.out.println("9. 이전 메뉴로");
            System.out.print("메뉴 번호 입력: ");
            int no = sc.nextInt();
            switch(no) {
                case 1:
                    menuService.searchMenuBySupCategory(inputSupCategory());
                    break;
                case 9:
                    return;
            }
        } while(true);
    }

    private static SearchCriteria inputSupCategory() {
        Scanner sc = new Scanner(System.in);
        System.out.print("상위 분류 입력(식사, 음료, 디저트): ");
        String value = sc.nextLine();

        return new SearchCriteria("category", value);
    }

    private static void ifSubMenu() {
        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();
        do {
            System.out.println("===== if Sub Menu =====");
            System.out.println("1. 원하는 금액대에 적합한 추천 메뉴 목록");
            System.out.println("2. 메뉴 이름 혹은 카테고리명으로 검색하기");
            System.out.println("9. 이전 메뉴로");
            System.out.print("메뉴 번호 입력: ");
            int no = sc.nextInt();
            switch(no) {
                case 1:
                    menuService.findMenuByPrice(inputPrice());
                    break;
                case 2:
                    menuService.searchMenu(inputSearchCriteria());
                    break;
                case 9:
                    return;
            }
        } while(true);
    }

    private static SearchCriteria inputSearchCriteria() {
        Scanner sc = new Scanner(System.in);
        System.out.print("검색 기준 입력(name or category): ");
        String condition = sc.nextLine();
        System.out.print("검색어 입력: ");
        String value = sc.nextLine();

        return new SearchCriteria(condition, value);
    }

    // 만원대로 구분, ex. 8000 입력시 0 ~ 8000, 12000 입력시 10001 ~ 12000
    private static int inputPrice() {
        Scanner sc = new Scanner(System.in);
        System.out.print("검색할 가격대의 최대 금액: ");

        return sc.nextInt();
    }
}
