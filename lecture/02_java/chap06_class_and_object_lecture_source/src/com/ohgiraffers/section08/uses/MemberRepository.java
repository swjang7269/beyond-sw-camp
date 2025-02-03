package com.ohgiraffers.section08.uses;

public class MemberRepository {
    private final static Member[] staticMembers = new Member[30];    // 데이터 저장소
    private static int count;   // 현재 저장된 마지막 회원의 수

    public static void store(Member[] members) {
        for (int i = 0; i < members.length; i++) {
            staticMembers[count++] = members[i];
        }
    }

    public static Member[] findAllMembers() {

        return staticMembers;
    }
}
