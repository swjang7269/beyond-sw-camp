package com.ohgiraffers.section02.extend.run;

import com.ohgiraffers.section02.extend.vo.*;

public class Application1 {
    public static void main(String[] args) {
        /* 수업목표. 제네릭 클래스를 좀 더 활용하는 예제를 이해할 수 있다. */
        // 이 3개가 컴파일 에라가 뜨는 이유는 <T extends Rabbit> 때문
//        RabbitFarm<Animal> farm1 = new RabbitFarm<>();    // Animal은 Rabbit이 될 수 없다.
//        RabbitFarm<Mammal> farm2 = new RabbitFarm<>();    // Mammal 또한 Rabbit이 될 수 없다.
//        RabbitFarm<Snake> farm3 = new RabbitFarm<>();     // Mammal 하위 클래스인 Snake 또한 마찬가지

        /* 설명. <T extends Rabbit>에 의해 Rabbit 및 하위 타입으로만 제네릭 객체 생성 가능 */
        // 객체 생성시에만 타입이 지정된다.
        RabbitFarm<Rabbit> farm4 = new RabbitFarm<>();          // Rabbit은 당연하게도 T extends Rabbit 가능                 Rabbit 타입만 변수에 대입 가능(Rabbit/Bunny/DrunkenBunny)
        RabbitFarm<Bunny> farm5 = new RabbitFarm<>();           // Bunny는 Rabbit 하위 클래스이므로 T는 extends Rabbit 가능    Bunny 타입만 대입 가능
        RabbitFarm<DrunkenBunny> farm6 = new RabbitFarm<>();    // DrunkenBunny 또한 마찬가지로 T는 extends Rabbit 가능       DrunkenBunny 타입만 대입 가능

        // 아래처럼 함수 호출 시 컴파일 에러가 뜨는 이유는 <?> 와일드 카드에 걸린 제약 때문
        farm4.setRabbit(new Rabbit());
        farm4.getRabbit().cry();
        farm4.setRabbit(new Bunny());   // Bunny는 Rabbit이 될 수 있다.(다형성) -> Rabbit 타입에 들어갈 수 있다.
        farm4.getRabbit().cry();        // 동적 바인딩

//        farm5.setRabbit(new Rabbit());    //Rabbit은 Bunny가 될 수 없다. 컴파일 에러
        farm5.setRabbit(new Bunny());
        farm5.getRabbit().cry();
    }
}
