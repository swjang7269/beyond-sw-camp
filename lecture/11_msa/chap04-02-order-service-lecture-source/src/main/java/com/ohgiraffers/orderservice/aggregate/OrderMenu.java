package com.ohgiraffers.orderservice.aggregate;

import lombok.Data;

@Data   // 나중엔 필요한 것만 달아주기
public class OrderMenu {
    private int orderCode;
    private int menuCode;
    private int orderAmount;

}
