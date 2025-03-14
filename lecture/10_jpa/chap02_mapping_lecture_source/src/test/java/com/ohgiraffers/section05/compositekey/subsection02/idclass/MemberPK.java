package com.ohgiraffers.section05.compositekey.subsection02.idclass;

import java.util.Objects;

/* 설명. IdClass 방식도 e/h를 오버라이딩 해야 한다. */
public class MemberPK {
    private int memberNo;
    private String memberId;

    public MemberPK() {
    }

    public MemberPK(int memberNo, String memberId) {
        this.memberNo = memberNo;
        this.memberId = memberId;
    }

    // 동등 비교를 위한 equals와 hashCode 오버라이딩
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MemberPK memberPK = (MemberPK) o;
        return memberNo == memberPK.memberNo && Objects.equals(memberId, memberPK.memberId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberNo, memberId);
    }
}
