package com.ohgiraffers.section02.package_and_import;

import com.ohgiraffers.section01.method.Calculator; // full-name 반복해서 적는 걸 막기 위함

public class Application2 {
    public static void main(String[] args) {
        /* 수업목표. import에 대해 이해할 수 있다.*/

        // non-static
        Calculator cal = new Calculator();
        int result = cal.plus(1, 2);
        System.out.println("result = " + result);

        // static
        result = Calculator.maxNumbersOf(1, 2);
        System.out.println("result = " + result);
    }
}
