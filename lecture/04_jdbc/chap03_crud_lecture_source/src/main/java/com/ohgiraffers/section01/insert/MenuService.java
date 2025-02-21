package com.ohgiraffers.section01.insert;

import java.sql.Connection;

import static com.ohgiraffers.common.JDBCTemplate.*;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

// 서비스 계층 - 커넥션 정보를 만들고 repo 계층으로 넘겨줌(직접 db와 통신하진 않는다)
/* 설명. Service 계층은 Connection 객체 생성 및 소멸(close) 및 비즈니스 로직, 트랜잭션 처리(commit/rollback) */
public class MenuService {

    public void registMenu(Menu menu) {
        // Connection 객체는 요청 하나당 개별로 할당되어야 한다. -> 전역 변수로 하면 안됨(여러 요청 발생 시 문제 발생)

        /* 설명. Connection 객체는 메소드 내부에서 생성하고 소멸한다.(요청별/트랜잭션별) */
        Connection con = getConnection();

        MenuRepository repository = new MenuRepository();
        int result = repository.insertMenu(con, menu);

        /* 설명. JDBCTemplate에 메소드 추가 */
        if (result == 1) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con); 
    }
}
