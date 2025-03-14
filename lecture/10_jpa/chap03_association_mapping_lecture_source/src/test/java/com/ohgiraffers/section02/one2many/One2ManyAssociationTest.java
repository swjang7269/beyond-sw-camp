package com.ohgiraffers.section02.one2many;

import jakarta.persistence.*;
import org.junit.jupiter.api.*;

import java.util.List;

public class One2ManyAssociationTest {
    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @BeforeAll
    public static void initFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }

    @BeforeEach
    public void initManager() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterEach
    public void closeManager() {
        entityManager.close();
    }

    @AfterAll
    public static void closeFactory() {
        entityManagerFactory.close();
    }

    @Test
    public void One2Many_연관관계_객체_그래프_탐색을_이용한_조회_테스트() {
        int categoryCode = 10;

        CategoryAndMenu categoryAndMenu = entityManager.find(CategoryAndMenu.class, categoryCode);
        System.out.println("categoryAndMenu = " + categoryAndMenu);

        List<Menu> menuList = categoryAndMenu.getMenuList();
        menuList.forEach(System.out::println);
    }
}
