package com.ohgiraffers.section03.grammer;

import java.util.EnumSet;
import java.util.Iterator;

public class Application {
    public static void main(String[] args) {
        UserRole1 admin = UserRole1.ADMIN;
        System.out.println(admin);
        System.out.println(admin.getNamtToLowerCase());

        UserRole2 consumer = UserRole2.CONSUMER;
        System.out.println(consumer.ordinal() + " " + consumer.name() + " " + consumer.getDESCRIPTION());

        /* 설명. Set의 개념으로 활용할 수도 있다.(feat.Iterator) */
        EnumSet<UserRole2> roles = EnumSet.allOf(UserRole2.class);
        Iterator<UserRole2> iter = roles.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next().name());
        }
    }
}
