package com.ohgiraffers.section02.annotation.common;

import org.springframework.stereotype.Component;

@Component
public class Squirtle implements Pokemon {
    @Override
    public void attack() {
        System.out.println("하이드로펌프💧💧");
    }
}
