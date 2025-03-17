package com.ohgiraffers.springdatajpa.common;

import org.springframework.data.domain.Page;

/* PagingButtonInfo를 활용하여 버튼을 만들기 위한 로직*/
/* 설명. Page 타입이 넘어오면 PagingButtonInfo를 반환하는 paging 기능 모듈*/
public class Pagination {
    public static PagingButtonInfo getPagingButtonInfo(Page page) {
        int currentPage = page.getNumber() + 1; // page는 index 개념 but 프론트에선 숫자 개념 -> 그 차이를 메꾸기 위한 + 1(back -> front로 전송 할 땐 + 1)
        int defaultButtonCount = 10;    // 한 화면애 보일 버튼 최대 갯수
        int startPage;                  // 해당 화면의 첫 버튼
        int endPage;                    // 해당 화면의 마지막 버튼
        
        startPage = (int)(Math.ceil(currentPage / (double)defaultButtonCount) - 1) * defaultButtonCount + 1;    // 모듈러 연산과 비슷한 개념 -1, + 1은 index와 숫자의 괴리를 맞추기 위함
        // (currentPage / defaultButtonCount) - 1 부분의 -1은 현재 페이지가 속한 블록의 인덱스
        // * defaultButtonCount를 통해 해당 블록의 첫 번째 페이지의 인덱스를 구함
        // defaultButtonCount + 1 의 +1 은 인텍스를 해당 페이지 번호
        // 해당 페이지가 몇 번째 싸이클에 위치하는지(defaultButtonCount가 10이라 가정 -> 11~20 -> 11으로, 21~30 -> 21으로, 121~130 -> 121으로 하기 위함)
        // defaultButtonCount 즉, 반복되는 1의 자리를 버리고 맨 앞을 추출하기 위함
        endPage = startPage + defaultButtonCount - 1;

        if (page.getTotalPages() < endPage) // totalPage가 마지막 페이지보다 작으면 totalPage가 마지막 페이지 버튼이 된다.
            endPage = page.getTotalPages();

        if (page.getTotalPages() == 0) {    // 화면에 보일 내용이 없다면 default로 1페이지 -> startPage와 endPage가 같다.
            endPage = startPage;
        }

        return new PagingButtonInfo(currentPage, startPage, endPage);
    }
}
