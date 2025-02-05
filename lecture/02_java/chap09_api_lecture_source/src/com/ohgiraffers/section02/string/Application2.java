package com.ohgiraffers.section02.string;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표. 문자열 객체를 생성하는 다양한 방법을 숙지하고 인스턴스가 생성되는 방식을 이해할 수 있다. */
        /* 설명.
         *  문자열 객체를 만드는 방법
         *  1. "" 리터럴 형태: 동일한 값을 가지는 인스턴스(동등(e, h))를 단일 인스턴스로 관리한다.
         *                    (일종의 singleton 개념, 상수풀(constant pool) 활용)
         *                     상수풀에 저장 단일 인스턴스
         *  힙 내부에 상수플(constant pool)이라는 특별한 곳을 마련해 놓아 ""리터럴 형태로 선언한
         *  값을을 저장시켜놓고 추가로 생성되어 메모리가 낭비되는 것을 막는다. eqauls와 hashcode를
         *  오버라이딩하여 ""리터럴 형태로 생성을 시도할 시 이미 상수풀에 존재하는 것이라면(동등 비교)
         *  추가 생성을 막고 참조만 하도록 만든다.
         *  2. new String("") 형태: 매번 새로운 인스턴스를 생성한다.(주소값이 매번 다름)
         * */
        String str1 = "java";
        String str2 = "java";
        String str3 = new String("java");
        String str4 = new String("java");

        System.out.println("str1 == str2: " + (str1 == str2));
        System.out.println("str2 == str3: " + (str2 == str3));
        System.out.println("str3 == str4: " + (str3 == str4));

        System.out.println("문자열 비교는 equals()를 사용하자: " + str2.equals(str3));
        System.out.println("hashCode()도 확인: " + str2.hashCode() + ", " + str3.hashCode());

        /* 설명. 문자열은 불변객체(immutable object)로 변화를 주면 항상 새로운 객체(인스턴스)가 생성된다. */
        String str = "apple";
        System.out.println(System.identityHashCode(str));
        str += ", banana";
        System.out.println(System.identityHashCode(str));
    }
}
