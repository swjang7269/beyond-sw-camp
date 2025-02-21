package com.ohgiraffers.section01.statement;

import java.sql.Connection;

import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application1 {
    public static void main(String[] args) {
        /* 설명. Connection 객체 생성 */
        Connection con = getConnection();


    }
}
