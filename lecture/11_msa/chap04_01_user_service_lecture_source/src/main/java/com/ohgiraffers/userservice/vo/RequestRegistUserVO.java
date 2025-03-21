package com.ohgiraffers.userservice.vo;

import lombok.Data;
// 요청 값을 받는 값
@Data
public class RequestRegistUserVO {
    private String email;
    private String name;
    private String pwd;
}
