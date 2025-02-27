package com.ohgiraffers.common;

// 직접적인 결합을 막고 간접적으로 결합하도록 결합도를 낮추고
// 인터페이스에 의존하도록 만들어 하위 구현체가 변경되더라도 인터페이스가 변경되지 않는 한 영향이 없도록 한다.
public interface Account {
    /* 설명. 잔액 조회 */
    String getBalance();

    /* 설명. 입금 */
    String deposit(int money);

    /* 설명. 출금*/
    String withDraw(int money);
}
