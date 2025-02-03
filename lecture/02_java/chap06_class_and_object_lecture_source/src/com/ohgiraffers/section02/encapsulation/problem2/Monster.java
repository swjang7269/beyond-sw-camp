package com.ohgiraffers.section02.encapsulation.problem2;

// 단일 책임의 원칙
public class Monster {
    public String name;
    int hp;
//    int mp;

    public void setInfo1(String info1){
        this.name=info1;
    }
    public void setInfo2(int info2){
        this.hp = info2;
    }
}
