package com.ohgiraffers.section01.xmlmapper;

import java.util.List;

public interface ElementMapper {

    List<MenuDTO> selectResultMapTest();

    List<Menu2CategoryDTO> selectResultMapAssociationTest();

    List<Category2MenuDTO> selectResultMapCollectionTest();
}
