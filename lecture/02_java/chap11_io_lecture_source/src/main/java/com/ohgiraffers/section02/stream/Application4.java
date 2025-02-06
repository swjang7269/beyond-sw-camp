package com.ohgiraffers.section02.stream;

import java.io.FileWriter;
import java.io.IOException;

public class Application4 {
    public static void main(String[] args) {
        /* 수업목표. FileWriter에 대해 이해할 수 있다. */
        FileWriter fw = null;
        try {
            fw = new FileWriter("src/main/java/com/ohgiraffers/section02/stream/testWriter.txt");
            fw.write("집 가고 싶다.\n");
            fw.write("아무것도 하기 싫다.\n");
            fw.write("아무것도 하고 있지 않지만\n");
            fw.write("격렬하게 아무 것도 하고 싶지 않다.\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
