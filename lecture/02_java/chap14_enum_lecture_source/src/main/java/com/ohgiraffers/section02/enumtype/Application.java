package com.ohgiraffers.section02.enumtype;

public class Application {
    public static void main(String[] args) {
//        Subjects subject1 = new Subjects(); // enum 타입의 생성자 직접 사용 불가
        Subjects subject1 = Subjects.JAVA;      // 최초 생성시 각 필드 타입별 객체 생성(lazysingleton)
        Subjects subject2 = Subjects.MARIADB;   // 최초 생성 이후 접근 시 추가 생성 X
        Subjects subject3 = Subjects.JAVA;

        /* 설명.
         *  1. 열거 타입으로 선언된 인스턴스는 싱글톤으로 괸리되며 인스턴스가 각각 한 개임을 보장
         *     작성한 순서에 따라 각각은 다른 인스턴스가 생성되며 최초 호출 시에 enum의 생성자를 활용해
         *     생성된다.(lazy singleton 개념)
         * 설명.
         *  2. 단일 인스턴스를 보장하기에 == 비교가 가능하다.(동일 객체 비교)
         */
//        if(subject1 == subject2) // 서로 다른 객체이다
        if(subject1 == subject3)    // singleton으로 관리하기에(1과 3은) 같은 객체이다.
            System.out.println("같은 과목");
        else
            System.out.println("다른 과목");

        /* 설명. 3. 상수 필드명을 문자열로 변경하기 쉽다. */
        System.out.println(Subjects.JAVA.toString());   // 오버라이딩 가능
        System.out.println(Subjects.JAVA.name());       // 오버라이딩 불가

        /* 설명. 4. values()를 이용하면 상수값 배열을 받환받고 이를 활용하여 연속처리해 줄수 있다.
         *         (상수 필드에 주입된 객체들을 순회할 수 있다.)
         */
        Subjects[] subjects = Subjects.values();
        for(Subjects sub : subjects){
            System.out.println(sub.toString());
            // enum에 선언된 상수들의 순서를 인덱스 체계로 추출
            System.out.println(sub.ordinal()); // 필드 선언 순서 출력 가능
            System.out.println(sub.name());
        }

        /* 설명. 5. 타입 안정성을 보장한다. */
        printSubjects(Subjects.JAVA);
//        printSubjects(0); // Subjects 타입이 아니면 전달될 수 없다.
    }

    private static void printSubjects(Subjects subjects) {

    }
}

