package com.ohgiraffers.section06.singleton;

// 객체가 하나만 있도록 하는 패턴, 생성자를 막아 하나만 존재하도록 설계하는 패턴
// 하나만 있어도 되고 리소스를 많이 먹는 것을 싱글톤으로 하자 -> 객체 생성의 시간을 줄이자
public class Application {
    public static void main(String[] args) {
        /* 수업목표. 싱글톤 패턴에 대해 이해할 수 있다. */
        /* 설명.
         *   singleton pattern이란?
         *   애플리케이션이 시작되고 난 후 어떤 클래스가 최초 한 번만 메모리에 할당(객체)되고
         *   그 메모리에 인스턴스가 단 하나만(private) 생성되어 공유(static)되게 하는 것을 싱글콘 패턴이라고 한다.
         *   (메모리 및 리소스 낭비 방지 목적)
         *
         * 설명.
         *  장점
         *   1. 첫 번째 이용 시에는 인스턴스를 생성해야 하므로 속도 차이가 나지 않지만
         *      두 번째 이후 이용 시에는 인스턴스 생성 시간 없이 바로 사용할 수 있다.(feat. 재사용)
         *   2. 인스턴스가 절대적으로 한 개만 할당 되는 것을 보증할 수 있다.
         *  단점
         *   1. 싱글톤 인스턴스가 너무 많은 일을 하거나 많은 데이터를 공유하면 결합도가 높아진다.
         *   2. 동시성 문제를 고려해서 설계해야 하기 때문에 난이도가 높다.
         *      - 멀티 스레드 환경에서 한정된 자원을 독점하는 문제(하나뿐인 객체를 공유하는 문제)
         *
         * 설명.
         *   구현 방법
         *   1. 이른 초기화(Eager Initialization)
         *   2. 늦은 초기화(Lazy Initialization)
         * */

        // main이 시작하자 마자 생성
        /* 설명. EagerSingleton은 프로그램 시작 시 바로 객체가 할당 */
        EagerSingleton eager1 = EagerSingleton.getInstance(); // 이미 생성된 유일한 객체를 받아온다.
        EagerSingleton eager2 = EagerSingleton.getInstance();

        // 동일한 객체를 받아온다.
        System.out.println("eager1 = " + System.identityHashCode(eager1));
        System.out.println("eager2 = " + System.identityHashCode(eager2));

        // 최초 호출 시 생성
        /* 설명. LazySingleton은 최초 호출 시 객체가 할당 */
        LazySingleton lazy1 = LazySingleton.getInstance();
        LazySingleton lazy2 = LazySingleton.getInstance();

        System.out.println("lazy1 = " + System.identityHashCode(lazy1));
        System.out.println("lazy2 = " + System.identityHashCode(lazy2));
    }
}
