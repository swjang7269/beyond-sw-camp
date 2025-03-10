package com.ohgiraffers.section02.xmlconfig;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Application {
    public static void main(String[] args) {
        String resource = "mybatis-config.xml"; // xml 파일 연결

        SqlSession session = null;
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource); // stream으로 외부 파일(xml) stream으로

            // inputStream을 이용하여 Factory 생성
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            session = sqlSessionFactory.openSession(false);

            java.util.Date date = session.selectOne("mapper.selectNow"); // mapper 소속의 selectNow의 쿼리문의 결과를 받아오겠다.
            System.out.println("date = " + date);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            session.close();
        }

    }
}
