package com.ohgiraffers.section04.testapp.service;

import com.ohgiraffers.section04.testapp.aggregate.AccountStatus;
import com.ohgiraffers.section04.testapp.aggregate.Member;
import com.ohgiraffers.section04.testapp.repository.MemberRepository;

import java.util.ArrayList;

/* 설명. 트랜잭션 처리(성공 실패에 따라 commit/rollback) 및 회원관리 비즈니스 로직 처리 */
public class MemberService {
    // 서비스 계층의 역할을 다하면 repository로 전달
    private final MemberRepository mr = new MemberRepository();

    public void findAllMembers() {
        ArrayList<Member> findMembers = mr.selectAllMembers();

        System.out.println("Service에서 조회 확인: ");
        for (Member member : findMembers) {
            System.out.println(member);
        }
    }

    public void findMemberBy(int memNo) {
        Member findMember = mr.selectMemberBy(memNo);

        if (findMember != null) {
            System.out.println("회원 정보 조회 성공: " + findMember);
        } else {
            System.out.println("등록된 회원 정보가 없습니다.");
        }
    }

    public void registMember(Member member) {
        /* 설명. 회원가입 시 입력받은 값 제외 두 개를 마저 채워준다. */
        /* 설명. 1. 회원 번호 추가 */
        int lastMemberNo = mr.selectLastMemberNo();
        member.setMemNo(lastMemberNo + 1);

        /* 설명. 2. 회원 활성화 상태 추가 */
        member.setAccountStatus(AccountStatus.ACTIVE);

        /* 설명. 모든 DML 작업(Insert/Update/Delete)이 일어난 행(객체)의 갯수가 return 값으로 받는다. */
        int result = mr.insertMember(member);
//        System.out.println("insert 성공 실패 여부: " + result);

        if (result == 1) {
            System.out.println("회원가입을 축하드립니다 " + member.getId() + "님");
        } else {
            System.out.println("회원가입에 실패했습니다.");
        }
    }

    public Member findMemberForMod(int memNo) {
        Member selectedMember = mr.selectMemberBy(memNo);

        // 사용자 조회가 안될 수 있는 경우 null이 반환되는 경우도 고려
        if (selectedMember != null) {
            // 해당 회원이 조회되었을 경우
            /* 설명. 조회된 회원을 그래도 반환해서 수정하면 Repository의 컬렉션에 담긴 객체가 수정된다. */
            /* 설명. 따라서 우리는 사본의 개염을 만들어 Repository의 컬렉션이 오염되지 않도록 할 것이다. */
            Member newInstance = new Member();
            newInstance.setMemNo(selectedMember.getMemNo());
            newInstance.setId(selectedMember.getId());
            newInstance.setPwd(selectedMember.getPwd());
            newInstance.setAge(selectedMember.getAge());

            // Member가 취미 배열을 참조하고 있기 때문에 hobbies를 그냥 복사해버리면
            // 얕은 복사가 일어난다. hobbies도 사본을 만들어 깊은 복사를 일으켜야한다.
            /* 설명. 취미는 배열이고 배열은 깊은 복사를 해 주어야 사본인 회원이 따로 취미 배열을 가지게 된다. */
            String[] copiedHobbies = selectedMember.getHobbies().clone();
            newInstance.setHobbies(copiedHobbies);
            newInstance.setBloodType(selectedMember.getBloodType());
            newInstance.setAccountStatus(selectedMember.getAccountStatus());

            System.out.println("조회된 회원(사본) 정보: " + newInstance);

            return newInstance;
        } else {
            System.out.println("해당 회원이 존재하지 않습니다.");
        }

        return selectedMember;
    }

    public void modifyMember(Member reformedMember) {
        int result = mr.updateMember(reformedMember);

        if (result == 1) {
            System.out.println(reformedMember.getId() + "회원 정보 수정 완료");
        } else {
            System.out.println("회원 정보 수정 실패");
        }

    }

    public void removeMember(int removeMemNo) {
        int result = mr.deleteMember(removeMemNo);
        if (result == 1) {
            System.out.println(removeMemNo + "번 회원 탈퇴 완료");
        } else {
            System.out.println("회원 탈퇴 실패");
        }
    }
}
