package com.ohgiraffers.section03.sqlInjection;

import java.sql.*;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application2 {
    private static String empId = "200";
    private static String empName = "' OR 1=1 AND EMP_ID + '200";

    public static void main(String[] args) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

//        SELECT * FROM EMPLOYEE WHERE EMP_ID = 200 AND EMP_NAME = '' OR 1=1 AND EMP_ID = ''200
        // 싱클 쿼테이션이 들어오는 경우 내부적으로 바꾼다.
        /* 설명.
         *  preparedStatement는 placeholder로 입력되는 값에 single cuotation(')이 있다면
         *  single cuotation을 하나 더 이어 붙이고 입력값 양 옆에도 single cuotation을 붙여준다.
         *  이를 통해 SQLInjection 공격을 막는다.
         */

        try {
            pstmt = con.prepareStatement("SELECT * FROM EMPLOYEE WHERE EMP_ID = ? AND EMP_NAME = ?");
            pstmt.setString(1, empId);
            pstmt.setString(2, empName);
            rset = pstmt.executeQuery();

            if(rset.next()) {
                System.out.println(rset.getString("EMP_NAME"));
            } else {
                System.out.println("No employee found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }
    }
}
