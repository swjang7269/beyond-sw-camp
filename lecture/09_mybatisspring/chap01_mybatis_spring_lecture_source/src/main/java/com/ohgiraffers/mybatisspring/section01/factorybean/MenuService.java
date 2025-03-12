package com.ohgiraffers.mybatisspring.section01.factorybean;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    /* 설명. 커넥션 객체인 SqlSessionTemplate */

    private final SqlSessionTemplate sqlSession;

    @Autowired  // 의존성 주입
    public MenuService(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    /* 설명. 메뉴의 활성화 상태('Y', 'N')에 따른 메뉴 조회 */
    public List<MenuDTO> findAllMenuByOrderableStatus(String test) {
        // sqlSession을 불러와 MenuMapper를 매퍼로 할당, 인터페이스의 추상메소드에 인자로 orderableStatus를 전달하며 메소드 수행
        return sqlSession.getMapper(MenuMapper.class).selectAllMenuByOrderableStatus(test);
    }
}
