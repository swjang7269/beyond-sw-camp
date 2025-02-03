package com.ohgiraffers.section08.uses;

import java.util.Arrays;

public class MemberService {
    /* 설명. 회원 가입을 5명 진행(저장)하기 위해 회원 가입용 객체의 메소드를 호출 */
    public void signUpMembers() {
        Member[] members = new Member[5];
        members[0] = new Member(1, "user01", "pass01", "홍길동", 20, 'M');
        members[1] = new Member(2, "user02", "pass02", "유관순", 16, 'F');
        members[2] = new Member(3, "user03", "pass03", "이순신", 40, 'M');
        members[3] = new Member(4, "user04", "pass04", "신사임당", 36, 'F');
        members[4] = new Member(5, "user05", "pass05", "윤봉길", 22, 'M');

        MemberRegister register = new MemberRegister();
        register.regist(members);
    }

    public void showAllMembers() {
        MemberFinder finder = new MemberFinder();
        System.out.println("===== 가입된 회원 목록 =====");
        Member[] returnMembers = finder.findAllMembers();
        for(Member m : returnMembers) {
            System.out.println(m);
        }
    }
}
