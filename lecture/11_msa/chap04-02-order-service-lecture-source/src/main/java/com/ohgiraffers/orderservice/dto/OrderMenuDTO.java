package com.ohgiraffers.orderservice.dto;

import lombok.Data;
// 계층 이동 시 필요한 것들
@Data
public class OrderMenuDTO {
    private int orderCode;
    private int menuCode;
    private int orderAmount;
    // --------------------
}
