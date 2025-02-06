package com.ohgiraffers.section02.stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Application3 {
    public static void main(String[] args) {
        /* 수업목표. FileReader를 이해하고 활용할 수 있다. */
        FileReader fr = null;
        try {
            fr = new FileReader("src/main/java/com/ohgiraffers/section02/stream/testReader.txt");

            int readChar = 0;
            while ((readChar = fr.read()) != -1) {
                System.out.print((char)readChar);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
