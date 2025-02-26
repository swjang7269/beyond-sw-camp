package com.ohgiraffers.section03.delete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.ohgiraffers.common.JDBCTemplate.*;

public class Application {
    public static void main(String[] args) {
        Connection con = getConnection();

        PreparedStatement pstmt = null;
        int result = 0;
        /* 설명. 1. soft delete */
        String querySoft = "UPDATE TBL_MENU SET ORDERABLE_STATUS = 'N' WHERE MENU_CODE  = ?";

        /* 설명. 2. hart delete */
        String queryHard = "DELETE FROM TBL_MENU WHERE MENU_CODE = ?";

        try {
            pstmt = con.prepareStatement(querySoft);
//            pstmt = con.prepareStatement(queryHard);
            pstmt.setInt(1, 3);
            result = pstmt.executeUpdate();

            if (result > 0) {
                System.out.println("delete 성공");
                commit(con);
            } else {
                System.out.println("delete 실패");
                rollback(con);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
            close(con);
        }
    }
}
