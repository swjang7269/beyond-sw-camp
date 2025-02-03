package com.ohgiraffers.section08.object_array;

public class Car {
    private String modelName;
    private int maxSpeed;

    public Car() {

    }

    public Car(String modalName, int maxSpeed) {
        this.modelName = modalName;
        this.maxSpeed = maxSpeed;
    }

    public void driveMaxSpeed() {
        System.out.println(modelName + " 차량의 최고 시속: " + maxSpeed + "km/h");
    }
}
