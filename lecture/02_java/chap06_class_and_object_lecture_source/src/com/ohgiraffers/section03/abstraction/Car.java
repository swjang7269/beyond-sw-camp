package com.ohgiraffers.section03.abstraction;

public class Car {
    private boolean isOn = false;
    private int speed;

    public void startUp() {
        if (this.isOn) {
            System.out.println("시동이 켜져 있습니다.");
        } else {
            this.isOn = true;
            System.out.println("시동을 걸었습나다.");
        }
    }

    public void go() {
        if (this.isOn) {
            this.speed += 10;
            System.out.println("speed = " + speed);
            System.out.println("가속 페달을 밟습니다.");
        } else
            System.out.println("시동을 먼저 걸어주세요.");

    }

    public void stop() {
        if (isOn) {
            if (speed > 0) {
                speed = 0;
                System.out.println("급브레이크를 밟았습니다.");
            } else {
                System.out.println("차는 이미 정차중입니다.");
            }
        } else {
            System.out.println("차에 시동이 걸려있지 않습니다.");
        }
    }

    public void turnOff() {
        if (isOn) {
            if (speed > 0) {
                System.out.println("달리는 상태에서 시동을 끌 수 없습니다.");
            } else {
                isOn = false;
                System.out.println("시동을 끕니다.");
            }
        } else {
            System.out.println("이미 시동이 꺼져 있습니다.");
        }
    }
}
