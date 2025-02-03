package com.ohgiraffers.section01.array;

public class Application5 {
    public static void main(String[] args) {
        /* 수업목표. 배열을 사용해 간단한 카드 뽑기 게임을 작성해보자. */
        String[] shape = {"SPADE", "CLOVER", "HEART", "DIAMOND"};
        String[] numbers = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        int randomShapeIndex = (int) (Math.random() * shape.length);
        int randomNumberIndex = (int) (Math.random() * numbers.length);
        System.out.println(shape[randomShapeIndex] + " " + numbers[randomNumberIndex]);
    }
}
