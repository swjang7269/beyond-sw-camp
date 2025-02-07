package com.ohgiraffers.section01.exception;

public class Application {
    // ArithmeticException은 unckecked로 이미 정리되어 있기에 생략 가능
    public static void main(String[] args) /*throws ArithmeticException*/ {
        /* 수업목표. 예외에 대해 이해하고 이를 처리하기 위한 문법을 활용할 수 있다.
         *  설명.
         *   1. throws를 통한 위임
         *   2. try-catch를 통한 처리
         * */

        /* 목차. 1. throws로 처리 시*/
        ExceptionTest et = new ExceptionTest();
        try {
            et.checkEnoughMoney(10000, 5000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // et.checkEnoughMoney(10000, 50000);
        /* 설명.
         *  기본적으로 ArithmeticException 발생 시 java단에서는 divided non zero
         *  main에서 catch로 예외 처리를 다룰 수 있다. */

//
//        /* 목차. 2. try-catch 처리 시*/
//        // try 블럭 내에서 예외가 발생 시 바로 해당되는 클래스로 이동
//        // 해당 예외 다름을 스킵
//        try
//        {
//            /* 설명. try 블럭은 처리할 예외가 발생할 적당한 범위를 감싼다. */
//            et.checkEnoughMoney(10000, 5000);
////            et.checkEnoughMoney(100000, 50000);
//            System.out.println("예외가 없습니다.");
//        // 적당한 크기로 지정
//        } catch (ArithmeticException e) {
//            /* 설명
//             *  try 블럭에서 발생한 예외(객쳬)를 처리하는 부분
//             *  예외 객체를 활용하게 되면 해당 예외 객체의 메소드를 사용할 수 있다.
//             */
//
//            /* 설명. 예외 메시지와 발생한 문제들을 추적할 수 있게 빨간 글씨의 메시지로 처리되는 방식 */
//            e.printStackTrace();    // 예외 호출 스택 구조 출력
//
//            System.out.println(e.getMessage());
//            System.out.println("돈 더 가져와");
//            //            System.exit(0);     // 자바 어플리케이션이 직시 종료되도록 처리
//        }
//
//        try{
//            int num = 10;
//            System.out.println(num / 0);
//
//        } catch (Exception e) {
//            System.out.println("0으로 나누면 안됨.");
//            System.out.println(e.getMessage());
//        }
//
//        System.out.println("프로그램 종료");
    }
}
