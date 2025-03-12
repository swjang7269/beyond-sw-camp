package com.ohgiraffers.transactional.section01.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderService {
    // order 도메인 이외의 도메인과 통신이 필요
    /* 설명. Order 도메인과 Menu 도메인 두 개를 하나의 Service에서 트랜잭션 상 쓰는 경우를 가정 */
    private OrderMapper orderMapper;
    private MenuMapper menuMapper;

    @Autowired
    public OrderService(OrderMapper orderMapper, MenuMapper menuMapper) {
        this.orderMapper = orderMapper;
        this.menuMapper = menuMapper;
    }

    // 해당 메소드를 transaction으로 보고 메소드가 종료 되기 이전에 에러가 발생하면 알아서 롤백해준다.
    /* 설명. Service 계층의 메소드가 DML 작업용 트랜잭션이면 @Transaction을 추가한다. */
    @Transactional
    public void registNewOrder(OrderDTO orderInfo) {
        /* 설명. 1. 주문한 메뉴 코드 추출(DTO를 통해) */
//        List<Integer> menuCodes = new ArrayList<>();
//        List<OrderMenuDTO> orderMenus = orderInfo.getOrderMenus();
//        for (OrderMenuDTO orderMenu : orderMenus) {
//            menuCode.add(orderMenu.getMenuCode());
//        }
        List<Integer> menuCodes = orderInfo.getOrderMenus().stream().map(OrderMenuDTO::getMenuCode).collect(Collectors.toList());

        Map<String, List<Integer>> map = new HashMap<>();
        map.put("menuCodes", menuCodes);

        /* 설명. 2. 주문한 메뉴 별로 Menu엔티티에 담아서 조회(select)해 오기(부가적인 메뉴 정보 추출) */
        // 주문 메뉴의 가격을 알기 위함
        List<Menu> menus = menuMapper.selectMenuByMenuCodes(map);
        menus.forEach(System.out::println);

        /* 설명. 3. 해당 주문건에 대해 총 주문 금액을 계산 */
        int totalOrderPrice = calcTotalPrice(orderInfo.getOrderMenus(), menus);

        /* 설명. 4. 일련의 과정을 거쳐 얻은 정보를 가지고 tbl_order 테이블에 추가(insert) */
        /* 설명. 4-1. OrderDTO -> Order */
        Order order = new Order(orderInfo.getOrderDate(), orderInfo.getOrderTime(), totalOrderPrice);

        // order를 전달하여 insert
        /* 설명. 4-2. Order로 insert(selectKey를 통해 insert를 하고 난 후 해당 객체의 orderCode에 select의 결과(주문번호)가 담긴 상태로 변한다.) */
        orderMapper.registOrder(order);
        System.out.println("insert 후 order = " + order);

        /* 설명. 5. tbl_order_menu 테이블에도 주문한 메뉴 갯수만큼 메뉴 추가(insert) */
        /* 설명. 5-1. OrderDTO -> List<OrderMenuDTO> -> List<OrderMenu> */
        List<OrderMenuDTO> orderMenuDTO = orderInfo.getOrderMenus();
        // 4번 과정의 order의 ORDER_CODE를 가져와야 한다.(selectKey를 통해 orderCode는 order에 담겨졌다.)
        for (OrderMenuDTO menuDTO : orderMenuDTO) {
            // OrderMenu 형태로 객체를 만들어 전달 -> tbl_order_menu에 insert
            orderMapper.registOrderMenu(new OrderMenu(order.getOrderCode() ,menuDTO.getMenuCode(), menuDTO.getOrderAmount()));
        }
        // 핵심.
        //  DTO는 계층간 전달을 위한 집합의 형태이다.
        //  DB 테이블과 형태가 일치하는 Entity 클래스를 만들어 Entity 형태로 DML 작업을 수행한다.(DTO 형태 X)
    }

    private int calcTotalPrice(List<OrderMenuDTO> orderMenus, List<Menu> menus) {
        int totalPrice = 0;

        int orderMenuSize = orderMenus.size();  // 몇 건의 주문이 있는지
        for (int i = 0; i < orderMenuSize; i++) {           // 사용자가 주문한 메뉴 종류만큼 반복
            OrderMenuDTO orderMenu = orderMenus.get(i);     // 해당 메뉴 주문 갯수 추출
            Menu menu = menus.get(i);                       // 해당 메뉴 가격 추출
            totalPrice += orderMenu.getOrderAmount() * menu.getMenuPrice();    // orderMenu에서 갯수를, menu에서 해당 메뉴의 가격을 추출
        }

        return totalPrice;
    }
}
