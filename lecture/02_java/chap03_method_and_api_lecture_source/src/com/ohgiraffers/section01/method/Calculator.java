package com.ohgiraffers.section01.method;

import static java.lang.Math.max;

public class Calculator {

    public int plus(int first, int second) {
        return first + second;
    }

    public int minus(int first, int second) {
        return first - second;
    }

    public int minNumbersOf(int first, int second) {
        return (first > second) ? second : first;   // min(first, second)
    }

    public static int maxNumbersOf(int first, int second) {
        return max(first, second);
    }
}