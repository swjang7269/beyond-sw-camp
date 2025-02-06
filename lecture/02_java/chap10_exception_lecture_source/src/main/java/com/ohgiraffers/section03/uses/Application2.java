package com.ohgiraffers.section03.uses;

import java.io.*;

public class Application2 {
    public static void main(String[] args) {
        /* 수업목표. try-with-resource 구문을 이해하고 활용할 수 있다.(feat. finally없이)*/
        try(BufferedReader br = new BufferedReader(new FileReader("test.dat"))) {

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
