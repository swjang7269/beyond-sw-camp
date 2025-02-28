package com.ohgiraffers.section02.annotation.subsection05.inject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.section02");

        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println("beanName = " + beanName);
        }

        // bean의 이름만으로 bean을 구분할 수 있으나 반환형이 Object라 타입 캐스팅이 필요할 수 있어 클래스 타입도 입력(아니면 따로 다운캐스팅 필요)
        PokemonService pokemonService = context.getBean("pokemonServiceInject", PokemonService.class);

        pokemonService.pokemonAttack();
    }
}
