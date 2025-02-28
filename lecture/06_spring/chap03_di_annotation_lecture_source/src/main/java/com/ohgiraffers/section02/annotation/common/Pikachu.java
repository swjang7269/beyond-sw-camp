package com.ohgiraffers.section02.annotation.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Primary    // 우선하여 선정
@Component
public class Pikachu implements Pokemon {
    @Override
    public void attack() {
        System.out.println("백만볼트⚡⚡");
    }
}
