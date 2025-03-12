package com.ohgiraffers.section01.xmlmapper;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.section01.xmlmapper.Template.getSqlSession;

public class ElementService {
    public void selectResultMapTest() {
        SqlSession sqlSession = getSqlSession();
        ElementMapper mapper = sqlSession.getMapper(ElementMapper.class);

        List<MenuDTO> menus = mapper.selectResultMapTest();
        menus.forEach(System.out::println);

        sqlSession.close();
    }

    public void selectResultMapAssociationTest() {
        SqlSession sqlSession = getSqlSession();
        ElementMapper mapper = sqlSession.getMapper(ElementMapper.class);

        List<Menu2CategoryDTO> menus = mapper.selectResultMapAssociationTest(); // menu를 기준으로 Category join(menu 1개 기준으로 category는 1개 즉, 1:1 -> Association)
        menus.forEach(System.out::println);

        sqlSession.close();
    }

    public void selectResultMapCollectionTest() {
        SqlSession sqlSession = getSqlSession();
        ElementMapper mapper = sqlSession.getMapper(ElementMapper.class);

        List<Category2MenuDTO> categories = mapper.selectResultMapCollectionTest(); // menu를 기준으로 Category join(menu 1개 기준으로 category는 1개 즉, 1:1 -> Association)
        categories.forEach(System.out::println);

        sqlSession.close();
    }
}
