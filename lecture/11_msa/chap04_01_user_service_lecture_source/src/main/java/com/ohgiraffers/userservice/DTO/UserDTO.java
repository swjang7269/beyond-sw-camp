package com.ohgiraffers.userservice.DTO;

import com.ohgiraffers.userservice.vo.ResponseOrder;
import lombok.Data;

import java.util.List;

// 계층을 오가며 비즈니스 로직을 실행할 때 필요한 값
@Data
public class UserDTO {
    private String email;
    private String name;
    private String pwd;

    /* 설명. 회원가입 진행하며 추가됨 */
    private String userId;

    /* 설명. orderService와 통신하여 조회해온 데이터(회원이 주문한 내역)를 저장하기 위함 */
    private List<ResponseOrder> orders;
}
