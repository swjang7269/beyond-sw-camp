package com.ohgiraffers.section02.looping;

import java.util.Scanner;

public class A_for {
    public void testSimpleForStatement() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + " 출력");
        }
    }

    public void testForExample() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Limit 값 입력:");
        int limit = sc.nextInt();

        int sum = 0;

        for (int i = 1; i <= limit; i++) {
            sum += i;
        }
        System.out.println("sum = " + sum);
    }
}
