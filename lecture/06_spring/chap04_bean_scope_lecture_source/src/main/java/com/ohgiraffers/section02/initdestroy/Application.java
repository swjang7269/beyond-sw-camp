package com.ohgiraffers.section02.initdestroy;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        /* 설명. 붕어빵, 우유, 삼다수를 진열 */
        Product carpBread = context.getBean("carpBread", Bread.class);
        Product milk = context.getBean("milk", Beverage.class);
        Product water = context.getBean("water", Beverage.class);

        /* 설명. 첫 번째 손님이 입장해서 쇼핑카트를 꺼내 물건을 담음 */
        ShoppingCart cart1 = context.getBean("cart", ShoppingCart.class);
        cart1.addItem(carpBread);
        cart1.addItem(milk);
        System.out.println("cart1 = " + cart1);

        /* 설명. 두 번쨰 손님이 입장해서 쇼핑카트를 꺼내 물건을 담음 */
        ShoppingCart cart2 = context.getBean("cart", ShoppingCart.class);
        cart2.addItem(water);
        cart2.addItem(milk);
        System.out.println("cart2 = " + cart2);

        /* 설명. main 메소드 종료 전에 Container를 제거(bean 강제 제거) */
        ((AnnotationConfigApplicationContext) context).close();
    }
}
