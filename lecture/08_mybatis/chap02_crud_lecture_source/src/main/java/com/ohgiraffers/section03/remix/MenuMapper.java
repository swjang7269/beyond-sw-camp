package com.ohgiraffers.section03.remix;

import java.util.List;
// remix 방식은 java방식에서의 쿼리부분을 xml방식으로 하려고 한다. -> 쿼리는 xml, DAO + Mapper를 인터페이스로
// 추상메소드와 xml에 적은 쿼리문을 연동시키려면 지켜야할 부분이 있다.
/* 설명.
 *  xml 방식(쿼리는 xml)과 java 방식(DAO+Mapper를 인터페이스로 -> DAO를 간단한 추상 메소드로)의 장점을 혼용하기 위한 방법
 *  1. xml 파일은 mapper용 인터페이스와 같은 이름으로 작성되어야 한다.
 *  2. xml 파일은 mapper용 인터페이스와 같은 경로에 위치해야 한다.
 *  3. xml 파일의 namespace는 mapper용 인터페이스로 작성해야 한다.(풀네임으로)
 *  4. xml 파일의 쿼리 id와 mapper용 인터페이스의 추상 메소드가 일치해야 한다.
 */
public interface MenuMapper {

    List<MenuDTO> selectAllMenus();

    MenuDTO selectMenuByMenuCode(int menuCode);

    int insertMenu(MenuDTO menu);

    int updateMenu(MenuDTO menu);

    int deleteMenu(int menuCode);

}
