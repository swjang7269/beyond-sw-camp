package com.ohgiraffers.section04.constructor;

public class User {
    // 해당 클래스 전역변수를 필드라고 부른다. (멤버라고도 부른다.)
    private String id;
    private String pwd;
    private String name;
    // Date형은 util 소속과 sql 소속 두가지가 있기때문에
    // 소속을 바로 알기 위해 임포트를 안하고 풀네임을 적어주는 경우가 많다.
    private java.util.Date enrollDate;

    // 기본 생성자 (반환형이 없는 메소드 형태)
    /* 설명. 기본 생성자(매개변수가 없는)를 활용한 객체 생성(반드시 명시적으로 쓰자!) */
    /* 설명. 명시적으로 매개변수가 있는 생성자를 만들면 자동으로 생성해주지 않을 수 있기에
    *   나중에 추가하더라도 문제가 없도록 습관적으로 명시적으로 쓰자 */
    public User(){
        System.out.println("기본 생성자 호출");

    }

    /* 설명. 원하는 필드를 초기화 하기 위한 매개변수 있는 생성자를 활용해 객체를 생성할 수 있다. */
    public User(String id, String pwd, String name) {
        System.out.println("매개변수 있는 생성자 호출");

        /* 설명. 생성자 안에서의 this.은 이 생성자로 만들어질 객체에 접근하는 것이다. */
        this.id = id;   // 객체 소속의 변수인지, 매개변수인지 이름이 같은 경우 인식 불가, 명시 필요
        this.pwd = pwd;
        this.name = name;
    }

    public User(String id, String pwd, String name, java.util.Date enrollDate) {
//        this.id = id;
//        this.pwd = pwd;
//        this.name = name;

        /* 설명. this()를 통해 다른 생성자를 활용하여 코드의 줄 수를 줄일 수 있다. */
        /* 설명. this()는 항상 첫 줄에 작성되어야 하며 1개만 작성 가능하다. */
        this(id, pwd, name);    // 같은 클래스 내의 다른 생성자 사용 가능
        System.out.println("한 개 더 추가!");
        this.enrollDate = enrollDate;
    }

    public String information() {
        return "id: " + id + ", pwd: " + pwd + ", name: " + name + ", enrollDate: " + enrollDate;
    }
}