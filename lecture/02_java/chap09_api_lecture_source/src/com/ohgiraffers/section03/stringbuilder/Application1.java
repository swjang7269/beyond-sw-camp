package com.ohgiraffers.section03.stringbuilder;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. String과 StringBuilder의 차이점에 대해 이해하고 사용할 수 있다. */
        StringBuilder sb = new StringBuilder("java");
//        StringBuilder sb2 = "java";             // 리터럴 형태로는 객체 생성 안됨

        String testStr = "java";
        StringBuilder testSb = new StringBuilder("kotlin");

        for (int i = 0; i < 9; i++) {
            testStr += i;
            testSb.append(i);

            System.out.println("String의 경우: " + System.identityHashCode(testStr));
            System.out.println("StringBuilder의 경우: " + System.identityHashCode(testSb));
            System.out.println("StringBuilder의 capacity의 변화: " + testSb.capacity());
        }

        System.out.println("String의 결과: " + testStr);
        System.out.println("StringBuilder의 결과: " + testSb);
    }
}
