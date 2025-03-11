package com.ohgiraffers.section01.xmlmapper;

import java.util.List;

public class Category2MenuDTO {
    private int categoryCode;
    private String categoryName;
    private Integer refCategoryCode;

    private List<MenuDTO> menus;

    public Category2MenuDTO() {
    }

    public Category2MenuDTO(int categoryCode, String categoryName, Integer refCategoryCode, List<MenuDTO> menus) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        this.refCategoryCode = refCategoryCode;
        this.menus = menus;
    }

    @Override
    public String toString() {
        return "Category2MenuDTO{" +
                "categoryCode=" + categoryCode +
                ", categoryName='" + categoryName + '\'' +
                ", refCategoryCode=" + refCategoryCode +
                ", menus=" + menus +
                '}';
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getRefCategoryCode() {
        return refCategoryCode;
    }

    public void setRefCategoryCode(Integer refCategoryCode) {
        this.refCategoryCode = refCategoryCode;
    }

    public List<MenuDTO> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuDTO> menus) {
        this.menus = menus;
    }
}
