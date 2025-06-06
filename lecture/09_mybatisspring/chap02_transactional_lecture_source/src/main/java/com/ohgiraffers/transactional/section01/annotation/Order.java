package com.ohgiraffers.transactional.section01.annotation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

// entity는 setter 적용을 지양
// 필요에 의해서만 setter가 만들어지는 것이 좋다.
public class Order {
    private int orderCode;
    private String orderDate;   // java에선 Date형을, DB에서는 VARCHAR형이므로 맞춰줘야함
    private String orderTime;
    private int totalOrderPrice;

    public Order() {
    }

    /* OrderDTO에 있던 값을 Order로 옮기기 위한 생성자 */
    public Order(LocalDate orderDate, LocalTime orderTime, int totalOrderPrice) {
        this.orderDate = orderDate.format(DateTimeFormatter.ofPattern(("yyyyMMdd")));
        this.orderTime = orderTime.format(DateTimeFormatter.ofPattern(("HH:mm:ss")));
        this.totalOrderPrice = totalOrderPrice;
    }

    public int getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(int orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public int getTotalOrderPrice() {
        return totalOrderPrice;
    }

    public void setTotalOrderPrice(int totalOrderPrice) {
        this.totalOrderPrice = totalOrderPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderCode=" + orderCode +
                ", orderDate='" + orderDate + '\'' +
                ", orderTime='" + orderTime + '\'' +
                ", totalOrderPrice=" + totalOrderPrice +
                '}';
    }
}
