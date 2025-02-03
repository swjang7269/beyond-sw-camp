package com.ohgiraffers.section04.comparison;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 비교연산자에 대해 이해하고 활용할 수 있다. */
        /* 목차. 1. 숫자값 비교 */
        int iNum1 = 10;
        int iNum2 = 20;
        System.out.println(iNum1 == iNum2);
        System.out.println(iNum1 != iNum2);
        System.out.println(iNum1 >= iNum2);
        System.out.println(iNum1 > iNum2);
        System.out.println(iNum1 <= iNum2);
        System.out.println(iNum1 < iNum2);

        System.out.println('a' > 10);   // a - 유니코드상 97, 문자도 숫자로 취급

        /* 목차. 논리값 비교 */
        boolean isNumber1 = true;
        boolean isNumber2 = false;
        System.out.println(isNumber1 == isNumber2);
        System.out.println(isNumber1 != isNumber2);
        //System.out.println(isNumber1 >= isNumber2);
        //System.out.println(isNumber1 > isNumber2);
        //System.out.println(isNumber1 <= isNumber2);
        //System.out.println(isNumber1 < isNumber2);
        
        /* 목차. 문자열 값 비교 */
        String str1 = "java";
        String str2 = "java";
        System.out.println(str1 == str2);
        System.out.println(str1 != str2);
        //System.out.println(str1 >= str2);
        //System.out.println(str1 > str2);
        //System.out.println(str1 <= str2);
        //System.out.println(str1 < str2);
    }
}