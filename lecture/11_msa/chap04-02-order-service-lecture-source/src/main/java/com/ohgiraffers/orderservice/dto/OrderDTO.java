package com.ohgiraffers.orderservice.dto;

import lombok.Data;

import java.util.List;

// DTO는 계층을 넘들때 필요한 정보에 따라 여러개 생성(resultMap 종류에 따라 모두 받을 수 있어야 한다. -> 여러개의 필드)
// 요청값, 응답값의 형태가 매번 달라질 것이다. join이 일어날수도, 안일어날 수도
// 추천. 요청 별로 해당 요청에 필요한 값을 받는 DTO를 만드는 것을 추천한다.
/* 설명. Query 쪽은 DTO로 계층 이동 및 DB와의 CRUD 관련해서까지 다 활용할 수 있지만
 *  DTO가 의미없이 모든 경우의 수를 감당해 내기보다는 DTO는 요청별로 구분해서
 *  설계하고 Entity 개념의 클래스는 모든 ResultMap의 결과를 받아 줄 수 있도록 설계하는 것을 추천한다.
 *  (DTO: 요청별 요청 및 응답 값 담는 용도)
 *  (Entity 계열의 클래스: 모든 ResultMap의 결과를 받아줄 수 있는 용도)
 */
// 요청에 맞는 형태로 DTO 작성
@Data
public class OrderDTO {
    private int orderCode;
    private int userId;
    private String orderDate;
    private String orderTime;
    private int totalOrderPrice;
    // -----------------------
    private List<OrderMenuDTO> orderMenus;
}
