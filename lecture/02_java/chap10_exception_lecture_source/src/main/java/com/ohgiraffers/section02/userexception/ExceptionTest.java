package com.ohgiraffers.section02.userexception;

import com.ohgiraffers.section02.userexception.exception.MoneyNegativeException;
import com.ohgiraffers.section02.userexception.exception.NotEnoughMoneyException;
import com.ohgiraffers.section02.userexception.exception.PriceNegativeException;

public class ExceptionTest {
    public void checkEnoughMoney(int price, int money) throws PriceNegativeException, MoneyNegativeException, NotEnoughMoneyException {
        if (price < 0) {
            throw new PriceNegativeException("상품 가격 음수 X");
        }
        if (money < 0) {
            throw new MoneyNegativeException("돈이 마이너스");
        }
        if (money < price) {
            throw new NotEnoughMoneyException("가진 돈보다 상품 가격이 더 비쌈");
        }

        /* 설명. 아무런 예외가 발생(throw)하지 않으면 실행 된다. */
        System.out.println("즐거운 쇼핑 되세요");
    }
}
