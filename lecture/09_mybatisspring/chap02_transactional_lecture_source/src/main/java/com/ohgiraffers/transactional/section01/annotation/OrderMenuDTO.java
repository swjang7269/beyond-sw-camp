package com.ohgiraffers.transactional.section01.annotation;

// DTO: 사용자의 입력을 받아 넘기기만 하면 됨 -> DB의 모든 컬럼과 대응될 필요 없음. 입력이 필요한 값만 받음
public class OrderMenuDTO {
    private int menuCode;       // 주문 메뉴 번호
    private int orderAmount;    // 주문 메뉴 갯수

    public OrderMenuDTO() {
    }

    public OrderMenuDTO(int menuCode, int orderAmount) {
        this.menuCode = menuCode;
        this.orderAmount = orderAmount;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    @Override
    public String toString() {
        return "OrderMenuDTO{" +
                "menuCode=" + menuCode +
                ", orderAmount=" + orderAmount +
                '}';
    }
}
