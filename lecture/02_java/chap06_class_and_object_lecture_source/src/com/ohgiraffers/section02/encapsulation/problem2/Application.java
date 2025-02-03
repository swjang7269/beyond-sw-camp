package com.ohgiraffers.section02.encapsulation.problem2;

public class Application {
    public static void main(String[] args) {
        Monster monster1 = new Monster();
        monster1.name = "드라큘라";
//        monster1.hp = 200;
        monster1.setInfo2(200);
    }
}
