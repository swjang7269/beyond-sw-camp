package com.ohgiraffers.section04.override;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        SuperClass subClass = new SubClass();

        SubClass subClass2 = new SubClass();
        try{
            subClass2.method2();
        } catch(Exception e) {
            throw new RuntimeException(e);
        }

        try {
            subClass.method();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
