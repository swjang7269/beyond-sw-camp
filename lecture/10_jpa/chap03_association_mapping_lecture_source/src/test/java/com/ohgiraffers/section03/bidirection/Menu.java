package com.ohgiraffers.section03.bidirection;

import jakarta.persistence.*;

@Entity(name="bidirection_category")
@Table(name="tbl_menu")
public class Menu {
    @Id
    @Column(name="menu_code")
    private int menuCOde;

    @Column(name="menu_name")
    private String menuName;

    @Column(name="menu_price")
    private int menuPrice;

    // menu 생성에는 category가 필요하여 category 생성에는 menu가 필요 -> 순환참조 발생
    @ManyToOne
    @JoinColumn(name="category_code")
    Category category;

    @Column(name="orderable_status")
    private String orderableStatus;

    public Menu() {
    }

    public Menu(int menuCOde, String menuName, int menuPrice, Category category, String orderableStatus) {
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
