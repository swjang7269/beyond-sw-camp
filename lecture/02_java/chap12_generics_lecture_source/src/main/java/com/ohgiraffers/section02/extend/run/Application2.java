package com.ohgiraffers.section02.extend.run;

import com.ohgiraffers.section02.extend.vo.*;

// wild 카드는 전달 인자에 대한 규약이다.
public class Application2 {
    public static void main(String[] args) {
        Rabbit r = new Bunny();
        RabbitFarm<Rabbit> rFarm = new RabbitFarm(r); // 여기서 rFarm에 Bunny가 들어가는 것은 다형성이고, <Rabbit> 은 <T extends Rabbit> 제약에서의 T가 될 수 있는 값이다.

        WildCardFarm wildCardFarm = new WildCardFarm();
        // RabbitFarm<?> 에서 ?는 Rabbit, Bunny, DrunkenBunny 모두가 될 수 있다.
        wildCardFarm.anyType(new RabbitFarm<Rabbit>(new Rabbit()));
        wildCardFarm.anyType(new RabbitFarm<Bunny>(new Bunny()));
        wildCardFarm.anyType(new RabbitFarm<DrunkenBunny>(new DrunkenBunny()));

        // RabbitFarm<? extends Bunny> 에서 ?는 Bunny 포함 하위 클래스만 될 수 있다.
//        wildCardFarm.extendsType(new RabbitFarm<Rabbit>(new Rabbit()));
//        wildCardFarm.extendsType(new RabbitFarm<Rabbit>(new Bunny()));
        wildCardFarm.extendsType(new RabbitFarm<Bunny>(new Bunny()));
        wildCardFarm.extendsType(new RabbitFarm<SubBunny>(new SubBunny())); // Bunny의 자식 클래스인 SubBunny는 가능
//        wildCardFarm.extendsType(new RabbitFarm<DrunkenBunny>(new DrunkenBunny()));

        // RabbitFarm<? super Bunny> 에서 ?는 Bunny 포함 상위 클래스만 될 수 있다.
        // 해당 예제에서 ?는 RabbitFarm <Rabbit>, <Bunny> 이다.
        wildCardFarm.superType(new RabbitFarm<Rabbit>(new Rabbit()));
        wildCardFarm.superType(new RabbitFarm<Rabbit>(new Bunny()));
        wildCardFarm.superType(new RabbitFarm<Rabbit>(new DrunkenBunny()));
        wildCardFarm.superType(new RabbitFarm<Bunny>(new Bunny()));

//        wildCardFarm.superType(new RabbitFarm<DrunkenBunny>(new DrunkenBunny()));
//        wildCardFarm.superType(new RabbitFarm<SubBunny>(new SubBunny())); // SubBunny는 Bunny의 자식이라 에러

    }
}
