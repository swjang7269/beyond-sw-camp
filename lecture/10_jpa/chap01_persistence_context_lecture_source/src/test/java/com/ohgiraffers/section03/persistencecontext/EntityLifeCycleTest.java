package com.ohgiraffers.section03.persistencecontext;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

public class EntityLifeCycleTest {
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

    /* 설명.
     *  영속성 컨텍스트(persistence context)
     *   영속성 컨텍스트는 엔티티 매니저가 엔티티 객체를 저장하는 공간으로 엔티티 객체를 보관하고 관리한다.
     *   엔티티 매니저가 생성될 때 하나의 영속성 컨텍스트가 할당된다.
     *
     * 설명.
     *  엔티티의 생명 주기
     *   비영속, 영속, 준영속, 삭제 상태
     */

    @Test
    public void 비영속성_테스트() {
        Menu foundMenu = entityManager.find(Menu.class, 11);

        /* 설명. 비영속 상태의 newMenu */
        // 동일한 값을 가지고 있더라도 persistence context에서 관리하는 객체와 동일한 객체는 아니다.
        Menu newMenu = new Menu();
        newMenu.setMenuCode(foundMenu.getMenuCode());
        newMenu.setMenuName(foundMenu.getMenuName());
        newMenu.setMenuPrice(foundMenu.getMenuPrice());
        newMenu.setCategoryCode(foundMenu.getCategoryCode());
        newMenu.setOrderableStatus(foundMenu.getOrderableStatus());


        Assertions.assertFalse(foundMenu == newMenu);
    }

    @Test
    public void 영속성_테스트() {
        // persistence context내에서 관리되는 엔티티는 동일한 id면 동일한 객체(주소가 동일)이다.
        Menu foundMenu1 = entityManager.find(Menu.class, 11);
        Menu foundMenu2 = entityManager.find(Menu.class, 11);

        Assertions.assertTrue(foundMenu1 == foundMenu2);
    }

    @Test
    public void 영속성_객체_추가_테스트() {
        /* 설명. 해당 예제에서는 @Id 속성의 AutoIncrement를 사용하지 않는다. */
        // 해당 예제를 수행하기 위해서는 Menu의 @Id 속성의 @GeneratedValue를 비활성화(주석처리) 할 것(menuCode의 자동 생성을 따르지 않고 사용자가 설정하기 위함)

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        // 해당 비영속 객체를 DB에 등록을 해보자
        Menu menuToRegist = new Menu();
        menuToRegist.setMenuCode(60);
        menuToRegist.setMenuName("일천");
        menuToRegist.setMenuPrice(5000);
        menuToRegist.setCategoryCode(1);
        menuToRegist.setOrderableStatus("Y");

        // 영속성 엔티티로 등록(insert)
        entityManager.persist(menuToRegist);
        // 등록하자마자 가져오기
        // 이 단계에서 내부적으로 DB와 동기화(flush)
        Menu foundMenu = entityManager.find(Menu.class, 50);

        transaction.commit();

        Assertions.assertTrue(menuToRegist == foundMenu);
    }

    @Test
    public void 영속성_객체_추가_및_변경_테스트() {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Menu menuToRegist = new Menu();
        menuToRegist.setMenuCode(70);
        menuToRegist.setMenuName("일천");
        menuToRegist.setMenuPrice(5000);
        menuToRegist.setCategoryCode(2);
        menuToRegist.setOrderableStatus("Y");

        // persistence context에 등록
        entityManager.persist(menuToRegist); // 여기서부터 menuToRegist는 영속 상태
        menuToRegist.setMenuName("범황");

        Menu foundMenu = entityManager.find(Menu.class, 70);

        transaction.commit();

        Assertions.assertEquals("범황", menuToRegist.getMenuName());
    }
}
