package com.ohgiraffers.section01.many2one;

import jakarta.persistence.*;

@Entity(name="menu_and_category")
@Table(name="tbl_menu")
public class MenuAndCategory {
    @Id
    @Column(name="menu_code")
    private int menuCOde;

    @Column(name="menuName")
    private String menuName;

    @Column(name="menuPrice")
    private int menuPrice;

    @ManyToOne
            @JoinColumn(name="category_code") // fk 제약조건에 있는 컬럼명(자식 테이블에 있는 컬럼명)
    Category category;  //  메뉴 한개가 카테고리 엔티티 객체를 몇개 갖나

    @Column(name="orderable_status")
    private String orderableStatus;

    public MenuAndCategory() {
    }

    public MenuAndCategory(int menuCOde, String menuName, int menuPrice, Category category, String orderableStatus) {
        this.menuCOde = menuCOde;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.category = category;
        this.orderableStatus = orderableStatus;
    }

    public int getMenuCOde() {
        return menuCOde;
    }

    public void setMenuCOde(int menuCOde) {
        this.menuCOde = menuCOde;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    public void setOrderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }

    @Override
    public String toString() {
        return "MenuAndCategory{" +
                "menuCOde=" + menuCOde +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", category=" + category +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }
}
