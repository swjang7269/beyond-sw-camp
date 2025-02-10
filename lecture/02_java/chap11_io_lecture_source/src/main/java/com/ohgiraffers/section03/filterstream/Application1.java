package com.ohgiraffers.section03.filterstream;

import java.io.*;
import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        /* 수업목표. BufferWriter와 BufferedReader에 대해 이해하고 사용할 수 있다. */
        /* 설명.
         *  내부적으로 버퍼(buffer)를 활용하여 입출력 성능을 향상 시킨다.
         *  추가적인 메소드가 제공된다.
         */

        // 기반 스트림? - 데이터를 직접 읽고 쓰는 기본적인 입출력 스트림 (FileReader, FileWriter, FileInputStream, FileOutputStream...)
        // 실데 데이터를 전달하는 통로 역할

        // 기반 스트림 정보를 활용하여 추가적인 기능을 사용하기 위한 스트림 -> 필터 스트림(보조 스트림)
        // 보조 스트림은 단독으로 쓰일 수 없고 기반 스트림을 감싸 부가기능을 제공한다.
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(
                    new FileWriter(
                            "src/main/java/com/ohgiraffers/section03/filterstream/testBuffered.txt"
                    )
            );

            // 버퍼에 들어온 값은 버퍼가 가득 차기 전까지 flush를 적용하지 않는다.(출력하지 않는다.)
            // 데이터를 일정 크기만큼 모아두었다가 한 번에 전송

            bw.write("집\n");
            bw.write("가고\n");
            bw.write("싶다.\n");

            /* 설명. 내부적으로 버퍼가 다 차지 않으면 출력으로 내보내 지지 않아 flush()를 호출해야 버퍼가 비워진다. */
            bw.flush(); // 버퍼가 가득 차지 않더라도 명시적으로 flush 가능(강제로 출력(전송))

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (bw != null) bw.close(); // close() 과정에서 내부적으로 flush 실행 -> 버퍼에 있는 값을 적용
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // 파일을 읽어 오는 구문
        BufferedReader br = null;
        try {
            br = new BufferedReader(
                    new FileReader(
                            "src/main/java/com/ohgiraffers/section03/filterstream/testBuffered.txt"
                    )
            );

            String str = "";
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
