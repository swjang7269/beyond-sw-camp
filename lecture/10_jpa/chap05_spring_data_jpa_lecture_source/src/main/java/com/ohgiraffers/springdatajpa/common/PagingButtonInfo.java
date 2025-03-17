package com.ohgiraffers.springdatajpa.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/* 페이지 버튼을 화면에 표시하기 위한 재료를 가진 객체 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class PagingButtonInfo {
    private int currentPage;
    private int startPage;
    private int endPage;
}
