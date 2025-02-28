package com.ohgiraffers.common;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Beverage extends Product {
    private int capacity;       // 용량(ml)

    public Beverage(String name, int price, int capacity) {
        super(name, price);
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Beverage{" +
                "capacity=" + capacity +
                "} " + super.toString();
    }
}
