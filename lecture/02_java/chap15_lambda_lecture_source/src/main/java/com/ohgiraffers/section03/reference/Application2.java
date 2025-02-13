package com.ohgiraffers.section03.reference;

import java.util.function.*;

public class Application2 {
    public static void main(String[] args) {
        /* 수업목표. 기존에 존재하는 생성자를 참조한 람다식을 활용할 수 있다. */
        // 생성자 또한 반환형이 없고 클래스명과 이름이 같은 메소드로 보고 참조할 수 있다.

        // String을 넘겨주고 Member를 반환받음
        // 넘겨진 String을 이용해 Member 생성자 참조
        // String을 이용해 생성된 Member를 반환 받음
        // 매개변수 타입에 맞게 함수 적용(오버로딩 된 함수여도 구분하여 적용됨)

        // String 매개변수를 하나 가진 생성자 참조
        Function<String, Member> costMember = Member::new;
        System.out.println(costMember.apply("user01"));

        Member member1 = costMember.apply("ara");
        System.out.println(member1);
        member1.setMemId("Devi");
        System.out.println("member1 = " + member1);

        Member member2 = costMember.apply("Apsara");
        System.out.println("member2 = " + member2);

        // int 매개변수 1개를 가진 생성자를 참조
        Function<Integer, Member> lineMember = Member::new;
        System.out.println(lineMember.apply(1));

        // 매개변수 타입에 맞춰 생성자가 알아서 참조된다.
        BiFunction<String, Integer, Member> araMem = Member::new;
        System.out.println(araMem.apply("shakti", 3));

        // 매개변수 없는 기본 생성자 참조
        Supplier<Member> supplier = Member::new;
        System.out.println(supplier.get());

        // 그러면 다른 클래스 참조할 때도 오버로딩된 함수를 매개변수에 따라서 알아서 매칭이되나?
        Consumer<String> mem1 = Member::abc;
        mem1.accept("shakti");

        Consumer<Integer> mem2 = Member::abc;
        mem2.accept(3);

        BiConsumer<Integer, String> mem3 = Member::abc;
        mem3.accept(55, "hi");

    }
}
