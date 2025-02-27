package com.ohgiraffers.common;

import lombok.ToString;

// 해당 데이터가 Account에 들어가야 한다.(주입해야 한다.)
// PersonalAccount -> Account
@ToString
public class PersonalAccount implements Account {
    // final 변수는 객체 생성시 무조건 초기화 필요(기본 생성자 X)
    private final int bankCode;     // 은행 코드
    private final String accNo;     // 계좌 번호
    private int balance;            // 잔액

    public PersonalAccount(int bankCode, String accNo) {
        this.bankCode = bankCode;
        this.accNo = accNo;
    }

    @Override
    public String getBalance() {
        return this.accNo + "계좌의 잔액: " + this.balance + "원";
    }

    @Override
    public String deposit(int money) {
        String str = "";

        if (money > 0) {
            this.balance += money;
            str = money + "원 입금";
        } else {
            str = "잘못 입력";
        }
        return str;
    }

    @Override
    public String withDraw(int money) {
        String str = "";

        if (this.balance >= money) {
            this.balance -= money;
            str = money + "원 출금";
        } else {
            str = "잔액 부족";
        }
        return str;
    }
}
