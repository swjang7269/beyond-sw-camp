package com.ohgiraffers.section02.prepared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.*;

public class Application2 {
    public static void main(String[] args) {
        Connection con = getConnection();

        PreparedStatement pstmt = null;
        ResultSet rset = null;

        Scanner sc = new Scanner(System.in);
        System.out.print("사번 입력: ");
        String empId = sc.next();

        System.out.println("퇴사 여부: ");
        String empYn = sc.next();

        try {                               // ?(PLACEHOLDER)를 이용해 사용자 변수를 받아 쿼리를 완성할 수 있다. prepared statement는 해당 쿼리를 캐싱한다.
            /* 설명. PreparedStatement는 Statement와 달리 placeholder(?)를 활용해 하나의 문자열 형태로 작성이 가능하다. */
            pstmt = con.prepareStatement("SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID = ? AND ENT_YN = ?");
            pstmt.setString(1, empId);  // place holder에 각 변수를 대입(자료형에 맞춰서 넣어줘야함)
            pstmt.setString(2, empYn);

            rset = pstmt.executeQuery();
            if (rset.next()) {
                System.out.println(rset.getString("EMP_ID") + "사번의 사원 이름: " + rset.getString("EMP_NAME"));
            } else {
                System.out.println("해당 사원이 없습니다.");
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
