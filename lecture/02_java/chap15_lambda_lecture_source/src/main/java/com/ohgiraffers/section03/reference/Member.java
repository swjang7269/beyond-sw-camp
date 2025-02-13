package com.ohgiraffers.section03.reference;

public class Member {
    private String memId;
    private int memLine;

    public Member() {
        System.out.println("기본 생성자");
    }

    public Member(String memId){
        System.out.println("매개변수 있는 생성자");
        this.memId = memId;
    }

    public Member(int memLine) {
        this.memLine = memLine;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    public Member(String memId, int memLine) {
        this.memId = memId;
        this.memLine = memLine;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memId='" + memId + '\'' +
                ", memLine=" + memLine +
                '}';
    }

    public static void abc(){
        System.out.println("기본");
    }

    public static void abc(int a){
        System.out.println("a = " + a);
    }
    public static void abc(String b){
        System.out.println("b = " + b);
    }
    public static void abc(int a, String b){
        System.out.println(a);
        System.out.println(b);
    }

}
