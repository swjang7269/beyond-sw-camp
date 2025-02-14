package com.ohgiraffers.section02.uses.subsection03.terminal;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Application5 {
    public static void main(String[] args) {
        /* 설명. 메소드 참조 관련 추가 설명(람다식 관련)*/
        // 해당 람다식을 적용할 객체에 대한 정보가 없고 BiConsumer의 매개변수가 2개이기에
        // 객체에 대한 정보와 값에 대한 정보를 넘겨 람다식을 적용
        BiConsumer<Member, String> biConsumer;
        biConsumer = Member::setMemberId;
        biConsumer = (x,y) -> x.setMemberId(y);

        // 해당 객체가 생성되어 있지 않다면 non-static함수를 사용하기 위해서는 클래스명::메소드명 을 참조
        // 객체에 대한 정보가 있고, 매개변수 한 개만 넣어 해당 객체에 대한 람다식을 적용할 때 사용 가능
        Consumer<String> consumer;
        Member m = new Member("1", "abc");
        consumer = m::setMemberId;

        consumer = (x) -> m.setMemberId(x);
    }
}
