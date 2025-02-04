package com.ohgiraffers.section01.polymorphism;

public class Application1 {
    public static void main(String[] args) {
        /* 수업목표. 다형성과 타입 형변환에 대해 이해할 수 있다. */
        Animal animal = new Animal();
        animal.eat();
        animal.run();
        animal.cry();

        System.out.println();

        Tiger tiger = new Tiger();
        tiger.eat();
        tiger.run();
        tiger.cry();
        tiger.bite();

        System.out.println();

        Rabbit rabbit = new Rabbit();
        rabbit.eat();
        rabbit.run();
        rabbit.cry();
        rabbit.jump();

        System.out.println();

        Animal an1 = new Animal();  // 다형성 X
        Animal an2 = new Tiger();   // 다셩성 O
        Animal an3 = new Rabbit();  // 다형성 O

        /* 설명. Animal은 Tiger나 Rabbit이 아니다. */
//        Tiger t1 = new Animal();    // 다형성 X  Animal은 Tiger의 멤버 즉, bite가 없기에 형변환이 불가능하다.

        // 정적 바인딩 - runtime 시점이 아닌 프로그램 실행 이전 당시의 연결 상태 (객체 생성 이전)
        // 동적 바인딩 - runtime 시점의 연결 상태 (객체 연결 이후 연결 상태) 실행 이후에 값이 정해짐(overriding)

        /* 설명. 동적 바인딩 확인하기
         *  컴파일 당시에는 해당 타입의 메소드와 연결되어 있다가
         *  런타임 당시 실제 객체가 가진 오버라이딩 된 메소드로 바인딩 되어 바뀌어 동작하는 것을 의미한다.
         *  (동적 바인딩의 조건: 상속, 다형성, 오버라이딩)
         *  다형성의 의의
         *  하위 타입을 상위 타입을 이용하여 관리
         */
        an1.cry();
        an2.cry();
//        an2.bite();   // Tiger는 bite가 있지만 Animal 타입으로 저장되어 있기에 Animal에 없는 bite에 접근할 수 없다.
        an3.cry();

        /* 설명. 부모 타입을 강제로 자식 타입으로 형변환 하는 것이 가능하다. (단, 조심해야 한다.) */
        /* 설명. 런타임시 발생할 수 있는 에러는 매우 조심해야 한다. */
        ((Tiger)an2).bite();
//        ((Rabbit)an2).jump();   // 컴파일 당시에는 해당 타입에 jump가 있는지 알 수 없기에 runtime시 에러 발생

        /* 설명. instanceof
         *  해당 객체의 타입을 런타임 시점에 확인하기 위한 연산자 -> 참이면 true, 거짓이면 false */
        if(an2 instanceof Tiger)
            ((Tiger)an2).bite();

        if(an3 instanceof Rabbit)
            ((Rabbit)an3).jump();

        Animal animal2 = new Tiger();   // 다형성 적용, 자동 형변환(auto up-casting, 묵시적 형변환)
        Rabbit rabbit2 = (Rabbit)an3;   // 다형성 적용 X, 강제 형변환(down-casting), 명시적 형변환
    }
}
