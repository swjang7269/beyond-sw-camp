package com.ohgiraffers.section02.encapsulation.resolved;

public class Application {
    public static void main(String[] args) {
        Monster monster1 = new Monster();
//        monster1.name = "드라큘라";
        monster1.setInfo1("드라큘라");
//        monster1.hp = 200;
        monster1.setInfo2(200);

        /* 설명.
         *  캡슐화(Encapsulation)
         *  캡슐화는 유지보수를 증가시키기 위해 필드(클래스의 속성)에 직접 접근을 제한하고
         *  public 메소드를 이용해서 간접적으로(우회해서) 접근하여 사용할 수 있도록 만든 기술이다.
         *  클래스 작성 시 특별한 목적이 있지 않다면 모든 필드에 대해 캡슐화를 적용하는 것을
         *  기본 원칙으로 하고 있다.
         *  -> 결합도를 낮추기 위해 사용 -> 단일 책임의 원칙
         * */
    }
}