package com.ohgiraffers.section01.insert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application1 {
    public static void main(String[] args) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;

        /* 설명.
         *  DML(insert, update, delete) 작업 시에는 반환 결과가 int값이 된다.(ResultSet X)
         *  그리고 조회에서는 executeQuery()를 썼다면 DML에서는 executeUpdate()를 쓰게 된다.
         */
        int result = 0;

        String query = "INSERT INTO TBL_MENU(MENU_NAME, MENU_PRICE, CATEGORY_CODE, ORDERABLE_STATUS) VALUES (?, ?, ?, ?)";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, "커피맛식혜");
            pstmt.setInt(2, 2000);
            pstmt.setInt(3, 5);
            pstmt.setString(4, "Y");

            result = pstmt.executeUpdate();

            // auto increment는 commit이 일어나지 않아도 작동하는 경우가 있다.
            // auto increment를 재설정 하여 의도대로 번호가 붙도록 할 수 있다.
            if(result > 0) {
                System.out.println("insert 결과: " + result + "행 추가");
                /* 설명. JDBCTemplate에 setAutoCommit(false) 설정 -> 수동 커밋 */
                con.commit();
            } else {
                System.out.println("insert 실패");
                // 실패시 롤백
                con.rollback();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
            close(con);
        }
    }
}
