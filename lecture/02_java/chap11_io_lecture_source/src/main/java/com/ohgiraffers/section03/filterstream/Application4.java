package com.ohgiraffers.section03.filterstream;

import com.ohgiraffers.section03.filterstream.dto.MemberDTO;

import java.io.*;

public class Application4 {
    public static void main(String[] args) {
        MemberDTO[] memArr = new MemberDTO[50];

        memArr[0] = new MemberDTO("user01", "pass01", "비천", "Apsara@email.com", 24, '여');
        memArr[1] = new MemberDTO("user02", "pass02", "범황", "Devi@email.com", 26, '여');
        memArr[2] = new MemberDTO("user03", "pass03", "대라", "Shakti@email.com", 27, '여');
        memArr[3] = new MemberDTO("user04", "pass04", "일천", "hong123@email.com", 20, '여');

        ObjectOutputStream oos = null;

        File ObjFile = new File("src/main/java/com/ohgiraffers/section03/filterstream/testObject.txt");

        // 최초 생성시에는 헤더가 생성되도록 하고 이후 추가할 때는 추가적으로 헤더가 생성되지 않도록 재정의한 스트림 사용

        try {
            if(!ObjFile.exists()){
                oos = new ObjectOutputStream( // 최초 선언시 헤더 생성
                        new FileOutputStream(
                                "src/main/java/com/ohgiraffers/section03/filterstream/testObject.txt", true
                        )
                );
            } else {
                oos = new MyOutput( // 추가 생성 시 헤더 X
                        new FileOutputStream(
                                "src/main/java/com/ohgiraffers/section03/filterstream/testObject.txt", true
                        )
                );
            }

            // 온전한 객체만 들어가도록 실체가 있는 수만큼 반복
            for (int i = 0; i < 4; i++) {
                oos.writeObject(memArr[i]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (oos != null) oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

// 테스트 흔적
/*
        try {
            oos = new ObjectOutputStream(
                    new FileOutputStream(
                            "src/main/java/com/ohgiraffers/section03/filterstream/testObject.txt", true
                    )
            );

            // memArr.length로 넣을 시 null값도 객체가 들어간건가?
            // 객체가 아닌 무언가가 들어가지 않도록 본인이 의도한 값만 들어가도록 잘 설정하고 고려해주어야 한다.
            for (int i = 0; i < 4; i++) {
                oos.writeObject(memArr[i]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (oos != null) oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            oos = new MyOutput(
                    new FileOutputStream(
                            "src/main/java/com/ohgiraffers/section03/filterstream/testObject.txt", true
                    )
            );
            for (int i = 0; i < 4; i++) {
                oos.writeObject(memArr[i]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (oos != null) oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

 */

        // null 값도 insert할 때 들어가서 추가로 insert하고 읽으려고 하면 받아오는 배열 크기가 더 커야 했다.
        // ex. memArr[10]을 3번 넣었을 때, newMemArr의 크기는 newMemArr[30]이 되었어야 했다. memArr.length로 insert하고 memArr.length로 받아와 크기가 부족하여 에러가 발생했다.
        MemberDTO[] newMemArr = new MemberDTO[memArr.length];

        // 객체 배열에 입력을 넣어올 때, 이미 기존의 배열에 가지고 있는 헤더와 나중에 추가되는 객체의 헤더가 충돌하는 일 발생
        // 추가하는 객체의 헤더는 아무 역할이 없도록 설정해줘야 객체의 헤더가 하나로 유지되며 충돌이 일어나지 않는다.

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(
                    new FileInputStream(
                            "src/main/java/com/ohgiraffers/section03/filterstream/testObject.txt"
                    )
            );

            // 반환형이 Object이므로 의도대로 동작을 하기 위해선 down-casting이 필요
            // 이 또한 입력을 받아오므로 EOF를 잘 고려해야함.
            // EOFException 예외 처리를 통해 처리(더 이상 읽을 객체가 없다.)
            int index = 0;
            while (true) {
                newMemArr[index++] = (MemberDTO) ois.readObject();
            }
        } catch (EOFException e) {
            System.out.println("회원 정보 읽기 완료");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (ois != null) ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        /* 설명. 출력 및 입력까지 잘 완료되었는지 새로운 배열의 회원 정보 확인 */
        for(MemberDTO mem : newMemArr) {
            System.out.println(mem);
        }
    }
}