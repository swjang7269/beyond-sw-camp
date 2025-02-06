package com.ohgiraffers.section02.stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Application2 {
    public static void main(String[] args) {
        /* 수업목표. FileOutputStreamd을 이해할 수 있다. */
        /* 설명.
         *  FileOutputStream은 FileInputStream과 달리 해당 파일이 존재하지 않으면 파일을 생성해 주며
         *  두 번째 전달 인자로 true를 전달하면 기존 데이터에 이어서 출력을 내보낼 수도 있다.
         */
        FileOutputStream fos = null;
        try {
            // true -> append(이어쓰기), false -> 덮어쓰기
            fos = new FileOutputStream("src/main/java/com/ohgiraffers/section02/stream/testOutputStream.txt", false);

            byte[] bArr = new byte[] {'I', ' ', 'w', 'a', 'n', 't', ' ', 'g', 'o', ' ', 'h', 'o', 'm', 'e'};
            fos.write(bArr);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
