package com.ohgiraffers.transactional.section01.annotation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class OrderDTO {
    private LocalDate orderDate;            // 서버 날짜
    private LocalTime orderTime;            // 서버 시간

    private List<OrderMenuDTO> orderMenus;  // 한 건의 주문 내 존재하는 사용자 주문 메뉴

    public OrderDTO() {
    }

    public OrderDTO(LocalDate orderDate, LocalTime orderTime, List<OrderMenuDTO> orderMenus) {
        this.orderDate = orderDate;
        this.orderTime = orderTime;
        this.orderMenus = orderMenus;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalTime orderTime) {
        this.orderTime = orderTime;
    }

    public List<OrderMenuDTO> getOrderMenus() {
        return orderMenus;
    }

    public void setOrderMenus(List<OrderMenuDTO> orderMenus) {
        this.orderMenus = orderMenus;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderDate=" + orderDate +
                ", orderTime=" + orderTime +
                ", orderMenus=" + orderMenus +
                '}';
    }
}
