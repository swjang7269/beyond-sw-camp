package com.ohgiraffers.section02.encapsulation.resolved;

public class Monster {
    // 정보 은닉
    private String name;    // 외부접근을 막음
    private int hp;

    public void setInfo1(String info1){
        this.name=info1;
    }
    public void setInfo2(int info2){
        this.hp = info2;
    }
}