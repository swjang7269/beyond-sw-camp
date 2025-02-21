package com.ohgiraffers.common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

// 반복적인 타이핑을 줄이고 가독성을 올리기 위한 모듈화
public class JDBCTemplate {
    public static Connection getConnection() {
        Properties prop = new Properties();
        Connection con = null;

        try {
            prop.load(
                    new FileReader(
                            "src/main/java/com/ohgiraffers/config/connection-info.properties")
            );
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");

            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);

            /* 설명. DML(insert, update, delete) 실행 시 자동 커밋 해제 */
            con.setAutoCommit(false);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return con;
    }

    public static void close(Connection con) {
        try {
            if(con != null) con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(Statement stmt) {
        try {
            if(stmt != null) stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet rset) {
        try {
            if(rset != null) rset.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void commit(Connection con) {
        try {
            if(con!= null) con.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void rollback(Connection con) {
        try {
            if(con!= null) con.rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
