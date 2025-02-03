package com.ohgiraffers.section05.parameter;

public class Rectangle {
    private int height;
    private int width;

    public Rectangle() {
    }

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public void calArea() {
        System.out.println("사각형의 넓이: " + (width * height));
    }

    public void calRound() {
        System.out.println("사각형의 둘레: " + (width + height) * 2);
    }
}
