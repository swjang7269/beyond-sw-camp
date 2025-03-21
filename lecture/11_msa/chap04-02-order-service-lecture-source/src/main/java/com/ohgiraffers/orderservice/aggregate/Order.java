package com.ohgiraffers.orderservice.aggregate;

import lombok.Data;

import java.util.List;

// resultMap과 동일하게(resultMap에 사용할 형태)
@Data
public class Order {
    // DB 테이블 과 동일한 구조
    private int orderCode;
    private int userId;
    private String orderDate;
    private String orderTime;
    private int totalOrderPrice;
    // 조인의 결과를 하나의 타입으로 다 받기 위함
    private List<OrderMenu> orderMenus;
}
