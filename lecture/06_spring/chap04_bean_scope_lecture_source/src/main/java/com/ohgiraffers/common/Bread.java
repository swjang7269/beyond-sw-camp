package com.ohgiraffers.common;

import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
public class Bread extends Product{
    private java.util.Date bakedDate;       // 제조 시간

    public Bread(String name, int price, Date bakedDate) {
        super(name, price);
        this.bakedDate = bakedDate;
    }

    @Override
    public String toString() {
        return "Bread{" +
                "bakedDate=" + bakedDate +
                "} " + super.toString();
    }
}
