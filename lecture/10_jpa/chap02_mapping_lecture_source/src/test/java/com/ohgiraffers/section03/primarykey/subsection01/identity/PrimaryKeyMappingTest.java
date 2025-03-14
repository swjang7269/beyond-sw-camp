package com.ohgiraffers.section03.primarykey.subsection01.identity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.util.Date;
import java.util.List;

public class PrimaryKeyMappingTest {
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
    public void 식별자_매핑_테스트() {
        // given
        Member member1 = new Member();
//        member.setMemberNo(1);
        member1.setMemberId("user01");
        member1.setMemberPwd("pass01");
        member1.setNickname("홍길동");
        member1.setPhone("010-1234-5678");
        member1.setEmail("hong@gmail.com");
        member1.setAddress("1번지");
        member1.setEnrollDate(new Date());
        member1.setMemberRole("ROLE_USER");
        member1.setStatus("Y");

        Member member2 = new Member();
//        member.setMemberNo(1);
        member2.setMemberId("user02");
        member2.setMemberPwd("pass02");
        member2.setNickname("유관순");
        member2.setPhone("010-1432-5678");
        member2.setEmail("yu@gmail.com");
        member2.setAddress("2번지");
        member2.setEnrollDate(new Date());
        member2.setMemberRole("ROLE_USER");
        member2.setStatus("Y");

        // when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(member1);
        entityManager.persist(member2);

        transaction.commit();

        /* 설명. persist 당시에는 부여되지 않은 pk값으로 commit 이후 조회가 가능할까? -> 쌉가능 */
        Member selectedMember = entityManager.find(Member.class, 1);
        System.out.println("selectedMember = " + selectedMember);

        /* 설명. 다중행 조회는 find로는 안되고 jpql이라는 문법을 사용해야 가능하다. */
        String jpql = "SELECT A.memberNo FROM member_section03_01 A";
        List<Integer> memberNoList = entityManager.createQuery(jpql, Integer.class).getResultList();
        memberNoList.forEach(System.out::println);
    }
}
