package com.ohgiraffers.section03.interfaceImplements;

import java.io.Serializable;

// 인터페이스는 다중 구현이 가능하다. 여러개의 인터페이스를 받아 구현 가능
public class Product implements InterProduct, Serializable {
    @Override
    public void nonStaticMethod() {
        System.out.println("InterProduct의 nonStaticMethod 오버라이딩 메소드...");
    }
}
