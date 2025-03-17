package com.ohgiraffers.section01.simple;

import jakarta.persistence.*;
import org.junit.jupiter.api.*;

import java.util.List;

public class SimpleJPQLTest {
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

    @Test
    public void TypedQuery를_이용한_단일행_단일명_조회_테스트() {
        String jpql = "SELECT menuName FROM menu_section01 WHERE menuCode = 7";     // jpa에서 DBMS에 맞는 쿼리문으로 수정해준다.
        TypedQuery<String> query = entityManager.createQuery(jpql, String.class);   // 쿼리문의 결과물의 타입을 string으로 받겠다.
        String resultMenuName = query.getSingleResult(); // 단일행만 가져온다.
        System.out.println("resultMenuName = " + resultMenuName);
    }

    @Test
    public void Query를_이용한_단일행_단일명_조회_테스트() {
        String jpql = "SELECT menuName FROM menu_section01 WHERE menuCode = 7";     // jpa에서 DBMS에 맞는 쿼리문으로 수정해준다.
        Query query = entityManager.createQuery(jpql);   // 쿼리의 반환형은 Ojbect이다.
        Object resultMenuName = query.getSingleResult(); // 단일행만 가져온다.
        System.out.println("resultMenuName = " + resultMenuName);

        /* 설명. 단일행 일부 다중열(Object[] 일 시) */
        /* 설명. jpql을 통해 일부분의 조회 결과 컬럼을 받아내는 것을 projection이라고 한다. */
        /*
        String jpql = "SELECT menuName, menuPrice FROM menu_section01 WHERE menuCode = 7";
        Query query = entityManager.createQuery(jpql);
        List<Object[]> resultColumns = query.getResultList();   // menuName와 menuPrice를 가진 Object[]로 반환된다.

        Arrays.stream(resultColumns.get(0)).forEach(System.out::println);
         */

        // 해당 쿼리 실행 시 해당 PK(7)에 해당 하는 1차 캐시 부분에 2개의 컬럼만 가진 것으로 덮어씌어지기 때문에, entity 활용이 힘들어진다.
        // 결국 일부분만 조회하는 것은 지양해야한다.
    }

    @Test
    public void TypedQuery를_이용한_다중행_다중열_조회_테스트() {
        String jpql = "SELECT m FROM menu_section01 m";
        TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class);

        List<Menu> resultMenu = query.getResultList();
        resultMenu.forEach(System.out::println);
    }

    @Test
    public void distinct를_활용한_중복제거_여러_행_조회_테스트() {
        /* 설명. 메뉴에 할당된 카테고리의 종류를ㄹ 조회하는 jpql 구문*/
        String jpql = "SELECT DISTINCT m.categoryCode FROM menu_section01 m";
        TypedQuery<Integer> query = entityManager.createQuery(jpql, Integer.class);
        List<Integer> resultCategoryCodeList = query.getResultList();

        resultCategoryCodeList.forEach(System.out::println);
    }

    @Test
    public void in_연산자를_활용한_조회_테스트() {
        String jpql = "SELECT m FROM menu_section01 m WHERE m.categoryCode IN (6, 10)";
        List<Menu> menuList = entityManager.createQuery(jpql, Menu.class).getResultList();

        menuList.forEach(System.out::println);
    }

    @Test
    public void like_연산자를_활용한_조회_테스트() {
        String jpql = "SELECT m FROM menu_section01 m WHERE m.menuName LIKE '%마늘%'";
        List<Menu> menuList = entityManager.createQuery(jpql, Menu.class).getResultList();

        menuList.forEach(System.out::println);
    }
}


