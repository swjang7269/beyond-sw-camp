package com.ohgiraffers.section02.enumtype;

public enum Subjects {
    // 각 타입은 싱글톤으로 관리
    JAVA,
    MARIADB,
    JDBC,
    HTML,
    CSS,
    JAVASCRIPT;

    // 최초 접근시 각 타입에 대한 객체를 생성(lazeSingleton)
    // 예제에선 위 6개 변수 타입으로 객체를 총 6개 생성
    Subjects() {
        System.out.println("기본 생성자 실행");
    }


    @Override
    public String toString() {
        return "@@@@@" + this.name() + "@@@@@";
    }
}
