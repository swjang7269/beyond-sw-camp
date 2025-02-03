package com.ohgiraffers.section03.abstraction;

    // CarRacer의 역할은 모인 각각의 기능(책임)들이다.
public class CarRacer {
    private Car myCar = new Car();
    // 각각의 기능 -> 책임
    public void startUp() {
        this.myCar.startUp();
    }

    public void stepAccelator() {

        this.myCar.go();
    }

    public void stepBreak() {
        this.myCar.stop();
    }

    public void turnOff() {
        this.myCar.turnOff();
    }
}
