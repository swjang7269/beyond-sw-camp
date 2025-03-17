package com.ohgiraffers.section03.bidirection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

public class BidirectionTest {
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

    @AfterAll
    public static void closeFactory() {
        entityManagerFactory.close();
    }

    @AfterEach
    public void closeManager() {
        entityManager.close();
    }

    /* 설명. 양방향 연관관계를 통해 엔티티 만들 엔티티 갯수는 줄어들지만 경우의 수를 모두 고려하여 설계해야 한다.(특히 순환참조를 고려해야 한다.) */
    @Test
    public void 양방향_영관관계_매핑_조회_테스트() {
        int menuCode = 10;
        int categoryCode = 10;

        /* 설명. 연관관계의 주인(자식 엔티티)은 한번에 left join문으로 관계를 맺은 엔티티를 조회해 온다. */
        Menu foundMenu = entityManager.find(Menu.class, menuCode);
        System.out.println("foundMenu = "+ foundMenu);
        System.out.println("10번 메뉴의 카테고리: " +foundMenu.getCategory());

        /* 설명. 양방향은 부모에 해당하는 엔티티는 가짜 연관관계이고 필요 시 연관관계 엔티티를 조회하는 쿼리로 작성된다.
         *          (FetchType.Lazy처럼 동작한다. */
        Category foundCategory = entityManager.find(Category.class, categoryCode);
        System.out.println("foundCategory = "+ foundCategory); // 순환 참조를 한부분은 끝맺음을 맺어줘야한다.
        System.out.println("10번 카테고리의 메뉴들: " +foundCategory.getMenuList());
    }
}
