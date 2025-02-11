package com.ohgiraffers.section03.map.run;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Application2 {
    public static void main(String[] args) {
        /* 수업목표. Properties에 대해 이해하고 활용할 수 있다. */
        /* 설명.
         *  Properties란?
         *   HashMap과 거의 유사하지만 key와 value 모두를 String으로만 사용할 수 있는
         *   자료구조이다.(제네릭을 별도로 요구하지 않음)
         *   주로 설정과 관련된 파일과의 입출력에 사용된다.(store, load 등)
         *  왜 쓸까?
         *   java 코드를 수정하고 압축하는데 오랜 시간이 소요된다.
         *   하지만 설정파일을 수정하는 것은 서버에 영향을 주지 않는다.
         *   설정파일을 따로 모아 수정을 용이하게 만들기 위해 사용한다.
         *   비개발자도 사용할 수 있도록 설정파일을 외부파일로 저장한다.
         */

        Properties prop = new Properties();
        // DB와 연동하기 위한 기존적인 4가지 엔트리
        prop.setProperty("driver", "oracle.jdbc.driver.OracleDiver");
        prop.setProperty("url", "jdbc:oracle:thin:@localhost:1521:xe");
        prop.setProperty("user", "swcamp");
        prop.setProperty("password", "swcamp");

        System.out.println(prop);

        // property를 이용하여 입출력을 다룰 수 있다.
        try {
            prop.store(new FileOutputStream("driver.dat"), "jdbc driver");
            prop.storeToXML(new FileOutputStream("driver.xml"), "jdbc driver xml version");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /* 출력으로 내보낸 파일을 읽어와서 새로운 Propertires에 담아보자. */
        Properties prop2 = new Properties();
        System.out.println("파일 읽기 전: " + prop2);

        try {
//            prop2.load(new FileInputStream("driver.dat"));
            prop2.loadFromXML(new FileInputStream("driver.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("읽어온 값");
        System.out.println("드라이버 " + prop2.getProperty("driver"));
        System.out.println("url " + prop2.getProperty("url"));
        System.out.println("id: " + prop2.getProperty("id"));
        System.out.println("password: " + prop2.getProperty("password"));
    }
}
