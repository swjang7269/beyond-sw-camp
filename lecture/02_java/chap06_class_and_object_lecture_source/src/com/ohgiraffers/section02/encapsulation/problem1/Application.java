package com.ohgiraffers.section02.encapsulation.problem1;

public class Application {
    public static void main(String[] args) {

        /* 수업목표. 필드에 직접 접근하는 경우 발생하는 문제점을 이해할 수 있다. */

        /* 설명. monster1 생성 */
        Monster monster1 = new Monster();
        // 클래스는 객체생성을 위한 구조일뿐, 클래스 내부에 값이 들어간다 생각하지 말 것
        // 값이 들어가는 곳은 new로 인해 할당된 메모리 상의 공간일 뿐
        monster1.name = "드라큘라";
        monster1.setHp(200);

        System.out.println("monster1의 이름: " + monster1.name);
        System.out.println("monster1의 체력: " + monster1.hp);

        /* 설명. monster2 생성 */
        Monster monster2 = new Monster();
        monster2.name = "프랑켄슈타인";
        monster2.setHp(300);    // setHp 내부의 this.은 monster2.과 같은 의미

        System.out.println("monster2의 이름: " + monster2.name);
        System.out.println("monster2의 체력: " + monster2.hp);
    }
}
