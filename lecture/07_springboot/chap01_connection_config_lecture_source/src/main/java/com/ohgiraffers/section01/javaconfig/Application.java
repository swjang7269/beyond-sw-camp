package com.ohgiraffers.section01.javaconfig;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Application {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/jdbcdb";
    private static String user = "root";
    private static String password = "mariadb";

    public static void main(String[] args) {
        /* 설명.
         *  JdbcTransactionFactory: 수동 커밋
         *  ManagedTransactionFactory: 자동 커밋
         *  --------------------------------------
         *  PooledDataSource: ConnectionPool 사용     ->  hikaricp(Spring boot에서 사용하는 상위 호환)
         *  UnPooledDataSource: ConnectionPool 미사용
         */
        Environment environment = new Environment(
                "dev",
                new JdbcTransactionFactory(),   // 수동 커밋을 하겠다.
                new PooledDataSource(driver, url, user, password)   // 커넥션 객체를 커넥션 풀에 미리 만들어 두겠다.
        );

        Configuration configuration = new Configuration(environment);
        configuration.addMapper(Mapper.class);      // 매퍼를 설정 파일에 등록하는 과정

        /* 설명
         *  SqlSessionFactory: SqlSession 객체를 생성하기 위한 팩토리 역할의 인터페이스
         *  SqlSessionFactoryBuilder: SqlSessionFactory 인터페이스 타입의 하위 구현 객체를 생성하기 위한 빌드 역할 - 빌드 역할을 다하면 던져진다.
         *  build(): 설정에 대한 정보를 담고 있는 Configuration 타입의 객체(java 방식) 혹은 외부 설정 파일과 연결된
         *           stream을 매개변수로 전달(xml 방식)하면 SqlSessionFactory 인터페이스 타입의 객체를 반환하는 메소드
         */
        // configuration을 바탕으로 SqlSession 객체 생성을 위한 팩토리
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        // -----------------------------------
        SqlSession session = sqlSessionFactory.openSession(false); // SqlSession 객체 생성, false를 작성해야 수동 커밋 완성

        Mapper mapper = session.getMapper(Mapper.class);    // 매퍼 정보 가져오기

        java.util.Date date = mapper.selectNow();   // 매퍼에 등록되어있는 쿼리문 가져오기(prepared statement
        System.out.println("date = " + date);       // 쿼리문의 결과를 받아온다.

        session.close(); // 세션 닫기
        // ----------------------------------- 트랜잭션 단위
    }
}
