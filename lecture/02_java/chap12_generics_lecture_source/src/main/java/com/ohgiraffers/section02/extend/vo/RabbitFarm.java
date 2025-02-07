package com.ohgiraffers.section02.extend.vo;

// RabbitFarm 객체는 Rabbit 타입만 가지도록 설정
// 객체 생성할 때 타입에 제약을 거는 것이다.
// 여기서의 T는 Rabbit 타입만 받을 수 있다. (Rabbit으로 다형성 적용이 되는 객체들 ex. Rabbit, Bunny, DrunkenBunny)

/* 설명. RabbitFarm 제네릭 클래스는 Rabbit 또는 Rabbit 하위 타입으로만 제네릭 타입을 지정할 수 있다. */
public class RabbitFarm<T extends Rabbit> {
    private T rabbit;

    public RabbitFarm(){
    }

    public RabbitFarm(T r) {
    }

    public T getRabbit() {
        return rabbit;
    }

    public void setRabbit(T rabbit) {
        this.rabbit = rabbit;
    }
}
