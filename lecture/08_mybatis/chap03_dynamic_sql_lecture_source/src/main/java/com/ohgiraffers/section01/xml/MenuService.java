package com.ohgiraffers.section01.xml;

import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.ohgiraffers.section01.xml.Template.getSqlSession;

public class MenuService {
    public void findMenuByPrice(int maxPrice) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper mapper = sqlSession.getMapper(MenuMapper.class); // ManuMapper 타입의 하위 구현체 생성

        List<MenuDTO> menus = mapper.selectMenuByPrice(maxPrice); // 인터페이스 내의 추상메소드 실행 -> 연동된 쿼리문 실행 -> 결과물 반환
        System.out.println("===== Service Layer =====");
        menus.forEach(System.out::println);
        sqlSession.close();
    }

    public void searchMenu(SearchCriteria searchCriteria) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper mapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO> menus = mapper.searchMenu(searchCriteria);
        System.out.println("===== Service Layer =====");
        menus.forEach(System.out::println);
        sqlSession.close();
    }

    public void searchMenuBySupCategory(SearchCriteria searchCriteria) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper mapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO> menus = mapper.searchMenuBySupCategory(searchCriteria);
        System.out.println("===== Service Layer =====");
        menus.forEach(System.out::println);
        sqlSession.close();
    }

    public void searchMenuByRandomMenuCode(List<Integer> randomList) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper mapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO> menus = mapper.searchMenuByRandomMenuCode(randomList);
        System.out.println("===== Service Layer =====");
        menus.forEach(System.out::println);
        sqlSession.close();
    }

    public void searchMenuByCodeOrSearchAll(SearchCriteria searchCriteria) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper mapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO> menus = mapper.searchMenuByCodeOrSearchAll(searchCriteria);
        System.out.println("===== Service Layer =====");
        menus.forEach(System.out::println);
        sqlSession.close();
    }

    public void searchMenuByNameOrCategory(Map<String, Object> searchCriteriaMap) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper mapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO> menus = mapper.searchMenuByNameOrCategory(searchCriteriaMap);
        System.out.println("===== Service Layer =====");
        menus.forEach(System.out::println);
        sqlSession.close();
    }

    public void modifyMenu(Map<String, Object> criteria) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper mapper = sqlSession.getMapper(MenuMapper.class);

        int result = mapper.updateMenu(criteria);

        if (result > 0) {
            System.out.println(" 수정 성공");
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();
    }
}
