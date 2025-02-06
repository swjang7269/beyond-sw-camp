package com.ohgiraffers.section02.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Application1 {
    public static void main(String[] args) {
        /* 수업목표. FileInputStream을 이해할 수 있다. */
        FileInputStream fis = null;
        // new file(파일명) 에서 new file 생략 가능
        try {
            fis = new FileInputStream("src/main/java/com/ohgiraffers/section02/stream/testInputStream.txt");

            int input = 0;

            // read()가 한 싸이클에 한번씩만 실행하도록 하기 위한 변수 선언 및 대입
            /* 설명. 반복 횟수를 셀 필요 없이 EOF(End Of File)를 반환값을 활용하여 처리할 수 있다. */
            while ((input = fis.read()) != -1) {
                System.out.print((char) input);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                // 파일 리소스 해제
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
