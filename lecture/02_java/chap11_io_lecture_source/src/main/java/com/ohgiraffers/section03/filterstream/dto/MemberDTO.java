package com.ohgiraffers.section03.filterstream.dto;

import java.io.Serializable;

// 객체 입출력의 대상이 되는 타입의 class에는 Serializable이 필요하다.
// Serializable은 객체 직렬화를 활성화를 위해 필요
// 자바에서 객체를 파일이나 네트워크로 전송하기 위해서는 바이트로 전환이 필요 -> 이 과정을 직렬화라 하며 반대의 경우(객체로 복원하는 과정)를 역직렬화라고 한다.
// 필요한 이유? - java에서는 객체를 직렬화 할 수 있는지 여부를 Serializable 인터페이스로 판단.
// Serializable을 구현하지 않으면 직렬화 할 수 없고 예외가 발생 NotSerializableException
// 메서드는 없고 단순히 이 객체가 직렬화가 가능하다는 정보만 제공 -> ObjectOutputStream과 같은 클래스들이 위 정보를 활용하여 동작
// 객체를 파일로 직렬화 할 때 파일의 맨 앞에 스트림 헤더(stream header)라는 정보가 자동으로 추가 (append 할 때 이 헤더가 충돌하는 경우가 발생 -> 오버라이드를 통해 기능 삭제)

public class MemberDTO implements Serializable {
    private String id;
    private String pwd;
    private String name;
    private String email;
    private int age;
    private char gender;

    public MemberDTO() {
    }

    public MemberDTO(String id, String pwd, String name, String email, int age, char gender) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.email = email;
        this.age = age;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
