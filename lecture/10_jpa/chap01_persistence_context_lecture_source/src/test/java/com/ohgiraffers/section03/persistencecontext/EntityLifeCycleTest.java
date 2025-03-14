package com.ohgiraffers.section03.persistencecontext;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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

        // persistence context에 등록(DB반영 X)
        entityManager.persist(menuToRegist); // 여기서부터 menuToRegist는 영속 상태
        menuToRegist.setMenuName("범황");

        Menu foundMenu = entityManager.find(Menu.class, 70); // 해당하는 영속 객체가 있기에 바로 반환(DB 반영 X)
        // 없을 경우 DB에서 조회해옴
        transaction.commit(); // 커밋 시점에 flush DB와 동기화(flush는 jpql이나 쿼리가 실행될때 수행)

        assertEquals("범황", menuToRegist.getMenuName());
    }

    @Test
    public void 준영속성_detach_테스트() {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Menu foundMenu1 = entityManager.find(Menu.class, 11);
        Menu foundMenu2 = entityManager.find(Menu.class, 12);
        System.out.println("foundMenu1 = " + foundMenu1);
        System.out.println("foundMenu2 = " + foundMenu2);

        /* 설명. 준영속 상태(detached entity)
         *  영속성 컨텍스트가 관리하던 엔티티 객체를 잠시 관리하지 않는 상태가 되게 한 것을 준영속 상태라고 한다.
         *  detach, clear, close가 준영속 상태를 만들기 위한 메소드이다.
         *
         * 설명.
         *  준영속을 사용하는 이유?
         *   JPA에서 엔티티를 더 이상 영속성 컨텍스트에서 관리하지 않음을 의미하며, 특정 상황에서 성능 최적화나
         *   데이터 무결성 유지, 특정 작업 후 엔티티 변경 방지를 위해 사용된다.
         */
        entityManager.detach(foundMenu2); // persistence context에서 뺀다. 이순간부터 foundMenu2는 영속성 객체가 아니다.
        foundMenu1.setMenuPrice(100);       // 해당 수정된 값은 commit할 때 update가 일어난다.
        foundMenu2.setMenuPrice(100);       // foundMenu2는 영속성 객체가 아니게 되었으므로 DB에 반영이 안된다.

        // detach를 통해 준영속상태가 된 객체를 다시 merge를 하면 다시 persistence context에 들어가며 그 사이 동일한 id의 영속성 객체가 있다면 덮어쓴다.

        transaction.commit();

        assertEquals(100, entityManager.find(Menu.class, 11).getMenuPrice());
        assertNotEquals(100, entityManager.find(Menu.class, 12).getMenuPrice()); // 이 순간 1차 캐시에 12번이 없으므로 select 발생

        entityManager.merge(foundMenu2); // 12번 영속성 객체를 덮어쓴다. but flush가 일어나진 않음(DB 반영 X)
        assertEquals(100, entityManager.find(Menu.class, 12).getMenuPrice()); // 12번 영속성 객체의 가격이 100으로 덮어써졌다.

        transaction.begin();
        transaction.commit(); // 다시 트랜잭션을 시작하여 flush가 동작하도록 하면 DB에도 반영된다. (12번 메뉴의 가격을 100으로)

    }

    @Test
    public void 준영속성_clear_close_테스트() {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Menu foundMenu1 = entityManager.find(Menu.class, 11);
        Menu foundMenu2 = entityManager.find(Menu.class, 12);

        entityManager.clear();  // persistence context에서 관리중인 모든 엔티티를 detached entity로 변경
//        entityManager.close();  // 기존의 Managed entity를 모두 detached entity로 변경시키며 persistence context를 닫는다.
                                // 다시 persistence context를 사용하려면 새로 entityManager를 생성하여 할당 받아야 한다.
                                // 새로 할당받은 persistence context에서 detached entity를 merge를 통해 다시 컨텍스트로 가져올 수 있다.

        foundMenu1.setMenuPrice(7000);
        foundMenu2.setMenuPrice(7000);

        transaction.commit();

        assertNotEquals(7000, entityManager.find(Menu.class, 11).getMenuPrice());
        assertNotEquals(7000, entityManager.find(Menu.class, 12).getMenuPrice());
    }

    @Test
    public void 병합_merge_수정_테스트() {
        EntityTransaction transaction2 = entityManager.getTransaction();
        transaction2.begin();   // persistence context는 파괴되었으나 트랜잭션이 살아있어서 해당 트랜잭션에서 덮어씌어진듯
        //별개의 트랜잭션에서 별개의 엔티티매니저 할당해서 하면 의도대로 동작... 내부 로직을 모르면 정확한 이유를 찾기는 어려울 듯

        Menu menuToDetach = entityManager.find(Menu.class, 5);
        entityManager.close();  // persistence context close (managed entity -> detached entity)
        transaction2.commit();

        entityManager = entityManagerFactory.createEntityManager();   // 새로운 persistence context 생성
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        menuToDetach.setMenuName("1234"); // detached entity를 수정한 거 아닌가? 왜 commit()할 때 update가 일어나는거지?
        System.out.println(entityManager.contains(menuToDetach));

        Menu refoundMenu = entityManager.find(Menu.class, 5);
        System.out.println(entityManager.contains(refoundMenu));
        System.out.println("menuToDetach = " + menuToDetach.hashCode());   // 이전 context에서 detach된 detached entity
        System.out.println("menuToDetach = " + menuToDetach);
        System.out.println("refoundMenu = " + refoundMenu.hashCode());     // 새로 DB에서 가져온 managed entity -> 두 객체는 다른 객체
        System.out.println("refoundMenu = " + refoundMenu);

        // detached entity가 덮어씌어진거 같은데? 왜 false가 DB에 반영이 되는거지

        refoundMenu.setMenuName("엘시");
        System.out.println("refound 변경");
        refoundMenu = entityManager.find(Menu.class, 5);

        transaction.commit();

        System.out.println("menuToDetach = " + menuToDetach);
        System.out.println("menuToDetach = " + menuToDetach.hashCode());
        System.out.println("refoundMenu = " + refoundMenu);
        System.out.println("refoundMenu = " + refoundMenu.hashCode());
//        menuToDetach.setMenuName("아라");
        // 왜 update가 됐지?
    }

    @Test
    public void close_test() {
        EntityTransaction transaction = entityManager.getTransaction(); // 트랜잭션 생성
        transaction.begin(); // 트랜잭션 시작

        Menu menu2Detach = entityManager.find(Menu.class, 4);    // 4번 메뉴 managed entity로
        System.out.println("menu2Detach 영속 여부: " + entityManager.contains(menu2Detach));    // managed entity -> true
        entityManager.close();  // persistence context close (menu2Detach는 detached entity)

        EntityManager entityManager2 = entityManagerFactory.createEntityManager();  // 새 entity manager 생성
//        System.out.println("entityManager의 menu2Detach 관리 여부: " + entityManager.contains(menu2Detach));    // detached entity -> false
        System.out.println("entityManager2의 menu2Detach 관리 여부: " + entityManager2.contains(menu2Detach));
        System.out.println("====== menu2Detach 수정 =====");
        menu2Detach.setMenuName("4321");
        System.out.println("수정 후 menu2Detach: " + menu2Detach);

        Menu newMenu = entityManager2.find(Menu.class, 3);
        System.out.println("newMenu 영속 여부: " + entityManager2.contains(newMenu));
        System.out.println("newMenu = " + newMenu);

        newMenu.setMenuName("2345");

        // newMenu가 적용이 안되는 이유
        // 새 EntityManager를 생성했을 때 새로운 persistence context가 아니라 close된 기존 context를 공유해버리는 현상

        // 원래대로라면 EntityManagerFactory.createEntityManager()를 호출하면 기본적으로 새로운 Persistence Context를 생성해야 함.
        // 그러나, 특정 설정에 따라 이전 Persistence Context를 공유할 수도
        // 같은 트랜잭션 범위 내에서 Persistence Context가 공유될 가능성이 있음.
        // 즉, EntityManager가 같은 트랜잭션을 공유하고 있다면, close() 후에도 Persistence Context가 유지될 가능성이 있음.

        // 그럼 머지를 통해 entityManager2가 detach를 관리하게 만들면 둘다 반영이 될까? id가 다른 영속 객체인데?
        // test2 : close 후 merge

//        entityManager.merge(menu2Detach); // 머지가 안되네? 새 엔티티 매니저를 이름을 달리하여 구분해보자
        Menu foundMenu = entityManager2.find(Menu.class, 4);
        System.out.println("foundMenu = " + foundMenu);
        System.out.println("menu2Detach 머지");
        entityManager2.merge(menu2Detach);    // 아이디가 같은 영속 객체가 있으면 덮어쓰기 되는지 확인해보자. DB연결은 안되어도 객체를 다루는 context 자체는 존재하는건 보인다.
        System.out.println("detached entity와 머지한 이후 id가 동일한 foundMenu = " + foundMenu);
        System.out.println("menu2Detach 영속 여부: " + entityManager2.contains(menu2Detach));
        System.out.println("foundMenu 영속 여부: " + entityManager2.contains(foundMenu));   // 덮어쓰기는 되지만 menu2Detach는 영속객체가 안되네?


        // 그럼 persist해보면?
//        entityManager2.persist(menu2Detach);
        // 새로 생성한 컨텍스트와 DB사이의 연결 자체가 안된다.
        // zjs
//        entityManager.persist(newMenu);  // 하지만 기존 entityManager는 close 되었으므로 기존 persistence context에 접근할 방법이 없네?
        // 이름을 통일시켜도 접근이 안됨

        transaction.commit();

        System.out.println("menu2Detach = " + menu2Detach);
        System.out.println("newMenu = " + newMenu);
        System.out.println("foundMenu = " + foundMenu);
    }

    // 그럼 트랜잭션 내에 새 트랜잭션 생성해서 해볼까?
    @Test
    public void transaction_test() {
        EntityTransaction transaction = entityManager.getTransaction(); // 트랜잭션 생성
        transaction.begin(); // 트랜잭션 시작

        Menu menu2Detach = entityManager.find(Menu.class, 4);    // 4번 메뉴 managed entity로
        System.out.println("menu2Detach 영속 여부: " + entityManager.contains(menu2Detach));    // managed entity -> true
        entityManager.close();  // persistence context close (menu2Detach는 detached entity)

        // 새 트랜잭션도 만들어보자
        EntityManager entityManager2 = entityManagerFactory.createEntityManager();  // 새 entity manager 생성
        EntityTransaction transaction2 = entityManager2.getTransaction();

        transaction2.begin();

        System.out.println("entityManager2의 menu2Detach 관리 여부: " + entityManager2.contains(menu2Detach));   // false
        System.out.println("====== menu2Detach 수정 =====");
        menu2Detach.setMenuName("1234");
        System.out.println("수정 후 menu2Detach: " + menu2Detach);

        Menu newMenu = entityManager2.find(Menu.class, 3);
        System.out.println("newMenu 영속 여부: " + entityManager2.contains(newMenu));
        System.out.println("newMenu = " + newMenu);

        System.out.println("====== newMenu 수정 =====");
        newMenu.setMenuName("9876");
        System.out.println("수정 후 newMenu: " + newMenu);

        Menu eqMenu = entityManager2.find(Menu.class, 4);   // 동일 id가 없다면 transaction.commit()이 일어날 떄 dirty checking이 발생(내부 구현상)
        eqMenu.setMenuName("5678");

//        entityManager2.merge(menu2Detach);  // 정상적으로 덮어쓰기 머지

        transaction2.commit();

        transaction.commit();

        System.out.println("menu2Detach = " + menu2Detach);
        System.out.println("id=3" + entityManager2.find(Menu.class, 3));
        System.out.println("id=4" + entityManager2.find(Menu.class, 4));
    }

    // 이름 통일해볼까?
    @Test
    public void transaction_test2() {
        EntityTransaction transaction = entityManager.getTransaction(); // 트랜잭션 생성
        transaction.begin(); // 트랜잭션 시작

        Menu menu2Detach = entityManager.find(Menu.class, 4);    // 4번 메뉴 managed entity로
        System.out.println("menu2Detach 영속 여부: " + entityManager.contains(menu2Detach));    // managed entity -> true
        entityManager.close();  // persistence context close (menu2Detach는 detached entity)

        // 새 트랜잭션도 만들어보자
        EntityManager entityManager = entityManagerFactory.createEntityManager();  // 새 entity manager 생성
        EntityTransaction transaction2 = entityManager.getTransaction();

        transaction2.begin();

        System.out.println("entityManager2의 menu2Detach 관리 여부: " + entityManager.contains(menu2Detach));   // false
        System.out.println("====== menu2Detach 수정 =====");
        menu2Detach.setMenuName("1234");
        System.out.println("수정 후 menu2Detach: " + menu2Detach);

        Menu newMenu = entityManager.find(Menu.class, 3);
        System.out.println("newMenu 영속 여부: " + entityManager.contains(newMenu));
        System.out.println("newMenu = " + newMenu);

        System.out.println("====== newMenu 수정 =====");
        newMenu.setMenuName("9876");
        System.out.println("수정 후 newMenu: " + newMenu);

        Menu eqMenu = entityManager.find(Menu.class, 4);   // 동일 id가 없다면 transaction.commit()이 일어날 떄 dirty checking이 발생(내부 구현상)
        eqMenu.setMenuName("5678");

//        entityManager2.merge(menu2Detach);  // 정상적으로 덮어쓰기 머지

        transaction2.commit();

        transaction.commit();

        System.out.println("menu2Detach = " + menu2Detach);
        System.out.println("id=3 " + entityManager.find(Menu.class, 3));
        System.out.println("id=4 " + entityManager.find(Menu.class, 4));
    }
}
