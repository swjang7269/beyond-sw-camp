package com.ohgiraffers.section01.user_type;

import java.util.Arrays;

public class Application {

    /* 설명.
     *   객체지향프로그래밍(OOP)란?
     *   OOP(Object Oriented Programming language)
     *   : 추상화, 캡슐화, 상속, 다형성을 적용하여 **유지보수성**을 고려한 응집력 높고
     *     결합도 낮은 객체 위주의 개발 방식을 적용한 프로그래밍을 말한다.
     *
     * 설명.
     *   객체지향의 특징(4대 특성)
     *  - 추상화(Abstraction)(추상화를 제외하면 3대 특성)
     *  - 캡슐화(Encapsulation)
     *  - 상속(Inheritance)
     *  - 다형성(Polymorphism)
     */
    public static void main(String[] args) {
        // 인스턴스화 - new 연산자를 통해 heap에 객체를 올리는 과정
        // 인스턴스 - 메모리에 올라간 상태의 객체 but 객체의 의미와 크게 구분하지 않는다.
        String id = "user01";
        String pwd = "pwd01";
        String name = "홍길동";
        int age = 20;
        char gender = '남';
        String[] hobbies = new String[]{"축구", "볼링", "테니스"};
        /* 설명.
         *  변수들로만 관리할때 발생하는 문제점
         *  1. 많은 변수를 관리하기 어려움 (한 묶음으로 생각하거나 코딩하기 어렵다)
         *  2. 메소드의 전달인자로 전달할 값이 많아 매개변수의 갯수가 늘어난다.
         *  3. 메소드의 반환형으로는 하나의 타입만 가능하지만 현재의 변수들론 불가능하다.
         */

        // 그저 변수 6개일 뿐 공통된 하나에 종속된 속성이라는 인식을 못한다.
        System.out.println("id = " + id);
        System.out.println("pwd = " + pwd);
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("gender = " + gender);
        System.out.println("habbies = " + Arrays.toString(hobbies));

        Member member1 = new Member();  // 여러 변수를 한 단위로 받아들임
        Member member2 = new Member();

        /* 설명. 사람 한명씩 접근해 이름을 부여하는 개념의 코드 */
        member1.name = "김철수";
        member2.name = "김영희";

        /* 설명. 김영희씨만 완성해보자 */
        member2.age = 19;
        member2.gender = '여';
        member2.hobbies = new String[]{"볼링", "하키"};
        member2.id = "user02";
        member2.pwd = "pwd02";

        /* 설명. 하나의 묶음으로 전달할 수 있고 (매개변수 1개), 반환할 수 있다. */
        System.out.println("김영희씨의 이름과 나이: " + member2.name + " " + member2.age);
        Member renamemember = test(member2);
    }

    private static Member test(Member member) {
        member.name = "까꿍";

        return member;
    }
}
