package com.ohgiraffers.section02.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

public class EntityManagerCRUDTest {
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
    public void 메뉴코드로_메뉴_조회_테스트() {
        int menuCode = 2;

        // entityManager가 관리 중인 엔티티에 menuCode = 2에 해당하는 것이 있다면 바로 반환 없으면 DB조회
        /* 설명. entityManager를 통해 여러번 find를 해도 select는 한번만 동작 */
        Menu foundMenu = entityManager.find(Menu.class, menuCode);

        System.out.println("foundMenu: " + foundMenu);
        // 단정문은 여러개 추가 가능 -> 모든 단정문이 통과되어야 통과
        Assertions.assertNotNull(foundMenu);
    }

    @Test
    public void 새로운_메뉴_추가_테스트() {
        Menu menu = new Menu();
        menu.setMenuName("버망");
        menu.setMenuPrice(5000);
        menu.setCategoryCode(4);
        menu.setOrderableStatus("Y");

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {
            entityManager.persist(menu);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    @Test
    public void 메뉴_이름_수정_테스트() {
        Menu menu = entityManager.find(Menu.class, 2);  // persistence context에 존재하는 entity를 가져와서 수정해야한다. pk가 2인 메뉴를 가져와라. 없으면 DB에서 가져와서 관리해라
        System.out.println("menu: " + menu);

        String menuNameToChange = "대라";

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {
            menu.setMenuName(menuNameToChange); // 2번 메뉴의 이름을 수정
            menu.setOrderableStatus("Y");
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    @Test
    public void 메뉴_삭제하기_테스트() {
        /* 설명. 지울 대상을 DB로부터 가져와서 엔티티로 관리하고 객체로 받음*/
        Menu menuToRemove = entityManager.find(Menu.class, 4);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {
            menuToRemove.setMenuPrice(3000);    // update가 일어나야하나 remove된 최종 결과 update가 필요없어 수행되지 않는다.
            entityManager.remove(menuToRemove); // 스냅샷과 트랜잭션 최종 결과 엔티티와 비교하여 필요한 만큼만 한번에 DML 작업 수행
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }
}
