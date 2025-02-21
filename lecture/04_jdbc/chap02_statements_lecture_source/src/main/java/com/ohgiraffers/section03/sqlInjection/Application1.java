package com.ohgiraffers.section03.sqlInjection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraffers.common.JDBCTemplate.*;

// sqlInjection 공격 - 항상 참이 나오도록 sql을 적절히 삽입하여 해당 sql이 무조건 수행되도록하는 공격 방법
public class Application1 {
    private static String empId = "200";
    private static String empName = "' OR 1=1 AND EMP_ID = '200";

    public static void main(String[] args) {
        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;

        String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID + '" + empId + "' AND EMP_NAME = '" + empName + "'";

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);
            if(rset.next()) {
                System.out.println(rset.getString("EMP_NAME"));
            } else {
                System.out.println("No employee found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(stmt);
            close(con);
        }
    }

}
