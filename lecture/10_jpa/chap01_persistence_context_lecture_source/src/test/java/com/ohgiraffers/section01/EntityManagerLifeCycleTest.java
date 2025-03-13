package com.ohgiraffers.section01;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

public class EntityManagerLifeCycleTest {
    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @BeforeAll
    public static void initFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }

    @BeforeEach
    public void initManager() {
        /* 설명. EntityManager가 생성될 때마다 고유의 새로운 persistence context(Entity 관리 창고) 생성*/
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

    // entityManagerFactory는 singleton으로 관리되며 entityManager는 매번 새로 생성된다.
    @Test
    public void 엔티티_매니저_팩토리와_엔티티_매니저_생명주기_확인1() {
        System.out.println("entityManagerFactory.hashCode1: " + entityManagerFactory.hashCode());
        System.out.println("entityManager.hashCode1: " + entityManager.hashCode());
    }

    @Test
    public void 엔티티_매니저_팩토리와_엔티티_매니저_생명주기_확인2() {
        System.out.println("entityManagerFactory.hashCode2: " + entityManagerFactory.hashCode());
        System.out.println("entityManager.hashCode2: " + entityManager.hashCode());
    }
}
