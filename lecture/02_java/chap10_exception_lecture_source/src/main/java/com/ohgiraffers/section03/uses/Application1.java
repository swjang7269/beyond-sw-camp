package com.ohgiraffers.section03.uses;

import java.io.*;

public class Application1 {
    public static void main(String[] args) {
        /* 수업목표. 예외 처리를 많이 사용하는 io패키지와 관련된 try-catch 구문을 이해할 수 있다. */
        /* 설명.
         *  예외 처리를 가장 많이 사용하게 되는 상황(io패키지 관련)에서 try-catch 구문을
         *  실제 상황과 유사하게 연습해보자.
         */
        // 해당 파일을 통해 파일 객체를 생성(파일 자체를 만든 것이 아니다.)
        /* 설명. 프로젝트 바로 아래 경로에 test.dat 파일이 있다면 그걸 인지한 File 객체 생성 후 절대 경로 출력 */
        System.out.println(new File("test.dat").getAbsolutePath());

        // 파일 test.dat를 읽어오기 위해 FileReader를 연결 추가기능을 위채 BufferedReader 추가
        // 파일을 찾지 못했을 경우의 예외 처리를 해줘야 한다.
        // 예외 발생 시에도 통신이 끝나면 닫아줘야 하기 때문에 finally를 사용하여 예외와 상관없이 제거해준다.
        BufferedReader br = null;
        try {
            // 예외 발생 시 객체 생성에 실패하고 br에는 null이 들어간다.
            br = new BufferedReader(new FileReader(new File("test.dat")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            // br에 null이 들어가 있을 수 있기 때문에 예외 상황도 고려하여 작성해야 한다.
            /* 설명.
             *  예외처리 구문과 상관없이 반드시 수행해야 하는 경우 finally에 작성하는데
             *  보통 사용한 자원(resource)를 반납하는 용도로 사용하게 된다.
             */
            try {
                if(br != null)
                    /* 설명.
                     *  입출력에서 사용한 스트림(통로)을 닫아주는 용도의 메소드
                     *  스트림이 없을 때(null)를 고려하고 IOException을 처리해야 제대로 쓸 수 있다.
                     */
                    br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
