package com.ohgiraffers.section01.scope.singleton;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ContextConfiguration {
    @Bean
    public Product carpBread() {
        return new Bread("붕어빵", 1000, new java.util.Date());
    }

    @Bean
    public Product milk() {
        return new Beverage("우유", 1500, 500);
    }

    @Bean
    public Product water() {
        return new Beverage("삼다수", 500, 500);
    }

    @Bean
//    @Scope("singleton") // default
    @Scope("prototype") // bean 스코프를 수정하게 되면 bean 객체의 life cycle을 다른 주기로 가져갈 수 있다. 즉, singleton이 아니게 된다.
    public ShoppingCart cart() {
        return new ShoppingCart();
    }
}
