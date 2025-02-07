package com.ohgiraffers.section03.filterstream;

import java.io.*;

public class Application3 {
    public static void main(String[] args) {
        /* 수업목표. 데이터 타입 입출력 보조 스트림을 이해하고 활용할 수 있다. */

        // 데이터 타입의 입력 결과는 두 눈으로 인식하기 어려운 부분이 있다. 깨진 것마냥 보이는...
        // 데이터 타입으로 읽어와 출력하는 방식으로 결과를 확인해야한다.
        // 이후로도 각 타입(스트림)에 맞춰 읽어와 출력하여 확인한다.

        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(
                    new FileOutputStream(
                            "src/main/java/com/ohgiraffers/section03/filterstream/testData.txt"
                    )
            );

            dos.writeUTF("집 가고 싶다.");
            dos.writeInt(10);
            dos.writeChar('A');

            dos.writeUTF("집 가고 싶다.");
            dos.writeInt(10);
            dos.writeChar('S');

            dos.writeUTF("집 가고 싶다.");
            dos.writeInt(10);
            dos.writeChar('B');

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (dos != null) dos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // 데이터 타입으로 읽어와서 수정해준다.
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(
                    new FileInputStream(
                            "src/main/java/com/ohgiraffers/section03/filterstream/testData.txt"
                    )
            );

            // DataInputStream은 null을 만나면 EOFException이 발생하는 점을 이용하여
            // 예외 처리로 반복을 종료한다.
            while (true) {
                // 데이터 타입은 각 데이터 타입에 맞춰 읽어들여야 한다.
                // 객체도 결국 데이터 타입이므로 객체 타입의 입출력도 해당 개념을 이해해야 한다.
                /* 설명. 데이터 단위를 지켜서 입력해야 온전히 데이터를 읽어들일 수 있다. */
                System.out.println(dis.readUTF());
                System.out.println(dis.readInt());
                System.out.println(dis.readChar());
            }

        } catch (EOFException e) {
            /* 설명. data 단위 입출력은 EOF를 EOFException 처리를 통해 확인하고 처리할 수 있다. */
            System.out.println("데이터 파일 읽기 완료");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (dis != null) dis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
