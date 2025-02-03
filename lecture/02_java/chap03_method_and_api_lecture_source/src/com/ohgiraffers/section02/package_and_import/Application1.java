package com.ohgiraffers.section02.package_and_import;
//mport com.ohgiraffers.section01.method.Calculator;
import com.ohgiraffers.section01.method.*;

public class Application1 {
    public static void main(String[] args) {
        /* 수업목표. 패키지에 대해 이해할 수 있다. */
        /* 설명.
        *   패키지의 의미
        *   1. 클래스의 소속
        *   2. 원래는 클래스명의 일부분이다.
        *   3. 경우에 따라 생략 가능
        * */

        /* 설명. non-static 메소드 호출을 위해 다른 패키지에서 Calculator 객체 생성 */
        com.ohgiraffers.section01.method.Calculator cal = new com.ohgiraffers.section01.method.Calculator();
        int plusResult = cal.plus(100, 20);
        System.out.println("plusResult = " + plusResult);

        /* 설명. static 메소드를 다른 패키지에서 호출해보기 */
        int maxResult = Calculator.maxNumbersOf(100, 20);
        System.out.println("maxResult = " + maxResult);

        int result = Calculator.maxNumbersOf(10,20);
    }
}
