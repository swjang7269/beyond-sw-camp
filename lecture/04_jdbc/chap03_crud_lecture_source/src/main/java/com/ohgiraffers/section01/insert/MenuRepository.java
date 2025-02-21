package com.ohgiraffers.section01.insert;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/* 설명. 넘어온 Connection 객체를 활용해 자신이 알고 있는 쿼리로 CRUD 실행하고 결과를 반환 */
public class MenuRepository {
    public int insertMenu(Connection con, Menu menu) {
        int result = 0;
        PreparedStatement pstmt = null;

        /* 설명. 쿼리는 XML 파일(mapper 파일)로부터 읽어와서 활용할 것 */
        Properties prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/section01/insert/mapper/menu-mapper.xml"));
            String query = prop.getProperty("insertMenu");

            pstmt = con.prepareStatement(query);
            pstmt.setString(1, menu.getMenuName());
            pstmt.setInt(2, menu.getMenuPrice());
            pstmt.setInt(3, menu.getCategoryCode());
            pstmt.setString(4, menu.getOrderableStatus());

            result = pstmt.executeUpdate();
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
