package com.ohgiraffers.section04.testapp.service;

import com.ohgiraffers.section04.testapp.aggregate.Member;
import com.ohgiraffers.section04.testapp.repository.MemberRepository;

import java.util.ArrayList;

/* 설명. 트랜잭션 처리(성공 실패에 따라 commit/rollback) 및 회원관리 비즈니스 로직 처리 */
public class MemberService {
    // 서비스 계층의 역할을 다하면 repository로 전달
    private final MemberRepository mr = new MemberRepository();

    public void findAllMembers() {
        ArrayList<Member> findMembers = mr.selectAllMembers();
    }
}
