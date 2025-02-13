package com.ohgiraffers.section04.testapp.repository;

import com.ohgiraffers.section04.testapp.aggregate.AccountStatus;
import com.ohgiraffers.section04.testapp.aggregate.BloodType;
import com.ohgiraffers.section04.testapp.aggregate.Member;
import com.ohgiraffers.section04.testapp.stream.MyObjectOutput;

import java.io.*;
import java.util.ArrayList;

/* 설명. 데이터베이스 개념(Member 관련 파일)과 입출력(CRUD)을 위해 만들어지며 성공데이터 또는 성공/실패 여부를 반환 */
// DML 작업은 int 형을 반환(몇 개의 영향을 줬느냐) -> 1개 insert는 1반환, 3개 삭제했으면 3반환
public class MemberRepository {
    /* 설명. 초기에 Member 파일이 없다면 파일을 만들어 더미데이터를 쌓는다. */
    private final ArrayList<Member> memberList = new ArrayList<>(); // DB로부터 읽어와서 자바 자료구조에 담기 위한 컬렉션
    private final File file = new File("src/main/java/com/ohgiraffers/section04/testapp/db/memberDB.dat");  // 설정 정보(DB 통신 정보)

    /* 설명. 프로그램 구동 시 MemberRepository 생성자가 호출되며 초기에 실행할 내용들 */
    public MemberRepository() {
        // 파일이 없을 시 최초 1번 생성
        if (!file.exists()) {
            ArrayList<Member> defaultMembers = new ArrayList<>();
            defaultMembers.add(new Member(1, "user01", "pass01", 20,
                    new String[]{"발레", "수영"}, BloodType.A, AccountStatus.ACTIVE));
            defaultMembers.add(new Member(2, "user02", "pass02", 10,
                    new String[]{"게임", "영화 시청"}, BloodType.B, AccountStatus.ACTIVE));
            defaultMembers.add(new Member(3, "user03", "pass03", 30,
                    new String[]{"음악 감상", "독서", "명상"}, BloodType.AB, AccountStatus.ACTIVE));

            saveMembers(defaultMembers);
        }

        loadMembers();
    }

    /* 설명. 파일로부터 회원 객체들을 읽어와서 memberList 컬렉션에 저장*/
    private void loadMembers() {
        try (ObjectInputStream ois = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(file)
                )
        )) {
            while (true) {
                memberList.add((Member) ois.readObject());
            }

        } catch (EOFException e) {
            System.out.println("회원 정보 조회 완료");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // 재활용을 위한 extract -> ArrayList<Member>를 받아 파일로 출력하는 메소드(덮어쓰기)
    // 다른 클래스에서 호출할 함수인지 아닌지 판단하여 캡슐화
    private void saveMembers(ArrayList<Member> inputMembers) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(file)
                    )
            );
            // Members를 파일에 출력
            for (Member member : inputMembers) {
                oos.writeObject(member);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (oos != null)
                    oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ArrayList<Member> selectAllMembers() {
        return memberList;
    }

    public Member selectMemberBy(int memNo) {
        Member returnMember = null;
        for (Member member : memberList) {
            if (member.getMemNo() == memNo) {
                returnMember = member;
            }

        }
        return returnMember;
    }

    public int selectLastMemberNo() {
        Member lastMember = memberList.get(memberList.size() - 1);
        return lastMember.getMemNo();
    }

    public int insertMember(Member member) {
        /* 설명. 헤더가 추가되지 않는 objectOutputStream 클래스 정의(MyObjectOutputStream) */
        MyObjectOutput moo = null;
        int result = 0;

        try {
            moo = new MyObjectOutput(
                    new BufferedOutputStream(
                            new FileOutputStream(file, true)
                    )
            );
            moo.writeObject(member);

            /* 설명. 컬렉션에도 신규회원 추가하기
             *  (MyObjectOutputStream으로 이어붙인 정보는 다시 입력받아도 이전 파일로 인식)
             *  (프로그램을 껐다 키면 다시 재인식이 되긴 함)
             *  현재 배운 내용만으로 구현하다 보니 맞이한 한계점
             */
            memberList.add(member);

            result = 1;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (moo != null) moo.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }

    /* 설명. 수정된 사본이 넘어오면(reformedMember) 컬렉션에 담긴 동일한 회원을 update하고 컬렉션의 회원 정보로 파일을 덮어씌운다.  */
    public int updateMember(Member reformedMember) {
        for (int i = 0; i < memberList.size(); i++) {
            if(reformedMember.getMemNo() == memberList.get(i).getMemNo()) {
                memberList.set(i, reformedMember);  // 컬렉션 업데이트
                saveMembers(memberList);    // 파일 업데이트(덮어쓰기)
                return 1;
            }
        }
        return 0;
    }

    /* 설명. soft delete(일종의 업데이트)를 통해 회원 탈퇴를 구성 */
    public int deleteMember(int removeMemNo) {
        int result = 0;

        for(Member mem : memberList) {
            if(mem.getMemNo() == removeMemNo){
                mem.setAccountStatus(AccountStatus.DEACTIVATED); // 컬렉션 업데이트
                result = 1;
                saveMembers(memberList); // 파일 업데이트(덮어쓰기)
            }
        }

        return result;
    }
}
