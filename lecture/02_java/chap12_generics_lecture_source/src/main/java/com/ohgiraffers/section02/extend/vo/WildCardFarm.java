package com.ohgiraffers.section02.extend.vo;

// 이미 생성되어 존재하는 제네릭 객체를 활용할 때 제약을 거는 것이다.
// ? 가 될 수 있는 타입에 대한 규약

/* 설명.
 *  와일드카드(wildcard)
 *  제네릭 클래스 타입의 객체를 메소드의 매개변수로 받을 때 타입 변수를 제한할 수 있다.
 *  <?>: 제한 없음
 *  <? extends Type>: 와일드 카드의 상한 제한(해당 Type과 Type의 후손을 이용해 생성된 제네릭 인스턴스만 가능)
 *  <? super Type>: 와일드 카드의 하한 제한(해당 Type과 Type의 부모를 이용해 생성된 제네릭 인스턴스만 가능)
 */
public class WildCardFarm {
    // <?> -> ?는 어떤 타입이든 될 수 있다. 해당 예제에선 RabbitFarm<T extends Rabbit>을 만족하는 모든 타입의 객체가 가능
    /* 설명. 어떤 타입의 RbbitFarm(제네릭 타입)이 와도 상관 없다. */
    public void anyType(RabbitFarm<?> farm) {
        farm.getRabbit().cry();
    }

    // <? extends Bunny> -> ?는 Bunny 또는 Bunnydml 자식(extends)(하위 클래스)만 될 수 있다.
    /* 설명. RabbitFarm 중에서도 Bunny 또는 하위 타입이 있는 RabbitFarm만 가능 */
    public void extendsType(RabbitFarm<? extends Bunny> farm) {
        farm.getRabbit().cry();
    }

    // <? super Bunny> -> ?는 Bunny 또는 Bunny의 super(상위 클래스)만 될 수 있다.
    /* 설명. RabbitFarm 중에서도 Bunny 또는 상위 타입이 있는 RabbitFarm만 가능 */
    public void superType(RabbitFarm<? super Bunny> farm) {
        farm.getRabbit().cry();
    }
}
