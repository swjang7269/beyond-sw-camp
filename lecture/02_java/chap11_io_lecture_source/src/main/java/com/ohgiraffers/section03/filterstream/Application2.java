package com.ohgiraffers.section03.filterstream;

import java.io.*;


public class Application2 {
    public static void main(String[] args) {
        /* 수업목표. 표준 입출력(콘솔과의 입출력)을 이해하고 활용할 수 있다. */
        // BufferedReader는 reader 계열에서 사용이 가능하다.
        // InputStreamReader를 활용하여 InputStream 계열(예제에선 System.in)을 reader 계열로 바꾼다.

        // 자바로 코테 준비를 한다면 익숙해져야 하는 구문
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("문자열 입력: ");
        try {
            String input = br.readLine();
            System.out.println(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        BufferedWriter bw = null;
        OutputStreamWriter osw = null;
        osw = new OutputStreamWriter(System.out);
        bw = new BufferedWriter(osw);

        try {
            bw.write("집 가고 싶다.");
            // bw.close()를 안 할거라면 명시적으로 bw.flush()를 해줘야한다.
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try{
                bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
