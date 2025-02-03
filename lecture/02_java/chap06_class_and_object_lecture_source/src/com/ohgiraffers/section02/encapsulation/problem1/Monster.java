package com.ohgiraffers.section02.encapsulation.problem1;

public class Monster {
    String name;
    int hp;

    public void setHp(int hp) {
        this.hp = Math.max(hp, 0);   // 메소드를 호출하기 위해 접근한 객체 -> this
    }
}
