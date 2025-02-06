package com.ohgiraffers.section01.file;

import java.io.File;
import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        /* 수업목표. 입출력 스트림에 대해 이해하고 파일을 대상으로 하는 FileInputStream을 이해하기 위해 File 객체 활용 */
        File file = new File("src\\main/java/com/ohgiraffers/section01/file/test.txt");

        try {
            boolean isSuccess = file.createNewFile();
            System.out.println("파일 생성 여부: " + isSuccess);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        /* 설명. 몇 가지 메소드를 살펴보자 */
        System.out.println("파일의 크기: " + file.length() + "byte");
        System.out.println("파일의 경로: " + file.getPath());
        System.out.println("현재 파일의 상위 경로: " + file.getParent());
        System.out.println("파일의 절대 경로: " + file.getAbsolutePath());

        boolean isDeleted = file.delete();
        System.out.println("파일 삭제 여부: " + isDeleted);
    }
}
