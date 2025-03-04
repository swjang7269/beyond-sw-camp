package com.ohgiraffers.section02.reflection;

public class Account {
    private String bankCode;
    private String accNo;
    private String accPwd;
    private int balance;

    public Account() {
    }

    public Account(String bankCode, String accNo, String accPwd) {
        this.bankCode = bankCode;
        this.accNo = accNo;
        this.accPwd = accPwd;
    }

    public Account(String bankCode, String accNo, String accPwd, int balance) {
        this.bankCode = bankCode;
        this.accNo = accNo;
        this.accPwd = accPwd;
        this.balance = balance;
    }

    /* 설명. 잔액 조회 */
    public String getBalance() {
        return this.accNo + " 계좌의 잔액: " + this.balance + "원";
    }

    /* 설명. 입금 */
    public String deposit(int money){
        String str = "";
        if(money >= 0){
            this.balance += money;
            str = money + "원 입금";
        } else {
            str = "금액을 잘못 입력하였습니다.";
        }
        return str;
    }

    /* 설명. 출금*/
    public String withdraw(int money){
        String str = "";
        if(money >= 0){
            this.balance -= money;
            str = money + "원 출금";
        } else {
            str = "금액을 잘못 입력하였습니다.";
        }
        return str;
    }
}
