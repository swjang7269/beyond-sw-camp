package com.ohgiraffers.section03.persistencecontext;

import jakarta.persistence.*;

// jpa가 인식하는 entity의 이름 지정
@Entity(name="section03_menu")
@Table(name="tbl_menu") // 해당 Entity가 어느 테이블과 매칭되는지 실제 테이블 명 명시
public class Menu {
    // 복합키 설정 방법 - 각각의 컬럼에 @Id 달기 or 복합키를 구성하는 컬럼을 모아 하나로 만들기 (추후 예제 확인)
    @Id // pk 명시
    @Column(name="menu_code") // 실제 테이블 컬럼값과 필드를 매칭
    /* 설명. Entity 객체를 만들 때 값을 넣지 않거나(DB의 auto_increment를 따르자)
        auto ddl을 통해 Entity로 테이블 생성 시(해당 entity 형태와 동일한 테이블을 생성 혹은 수정) 활용할 목적 */
    //@GeneratedValue(strategy=GenerationType.IDENTITY) // pk 발생 기준(IDENTITY: Auto increment, AUTO: DBMS에 맞춰서... 등등)
    private int menuCode;

    @Column(name="menu_name")
    private String menuName;

    @Column(name="menu_price")
    private int menuPrice;

    @Column(name="category_code")
    private int categoryCode;

    @Column(name="orderable_status")
    private String orderableStatus;

    public Menu() {
    }

    public Menu(int menuCode, String menuName, int menuPrice, int categoryCode, String orderableStatus) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.categoryCode = categoryCode;
        this.orderableStatus = orderableStatus;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
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

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    public void setOrderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", categoryCode=" + categoryCode +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }
}
