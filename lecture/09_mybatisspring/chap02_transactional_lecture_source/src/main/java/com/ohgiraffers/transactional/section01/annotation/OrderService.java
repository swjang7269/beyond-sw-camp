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

    /* 설명. 서비스 메소드 내부에서 모든 DML관련 작업에 예외 없이 잘 동작하면 commit, 예외가 발생하면 rollback이 적용된다. */
    /* 설명. 전파행위 옵션(propagation) (트랜잭션 내부에 다른 트랜잭션이 있는 경우 중첩 트랜잭션 내의 내부 트랜잭션이 어떻게 실행될지에 대한 설정)
     *          - 하나의 서비스에서 다른 서비스의 메서드를 호출할 때, 기존 트랜잭션을 유지할지, 새 트랜잭션을 생성할지, 기존 트랜잭션을 종료할지
     *  REQUIRED : 진행 중인 트랜잭션이 있으면 현재 메소드를 그 트랜잭션에서 실행하되 그렇지 않은 경우 새 트랜잭션을 시작해서 실행한다.
     *          - 롤백시 전체 트랜잭션이 롤백된다.(하나의 큰 트랜잭션 단위로 본다.)
     *  REQUIRED_NEW : 항상 새 트랜잭션을 시작해 메소드를 실행하고 진행중인 트랜잭션이 있으면 잠시 중단시킨다.
     *          - 항상 새로운 트랜잭션
     *  SUPPORTS : 진행중인 트랜잭션이 있으면 현재 메소드를 그 트랜잭션 내에서 실행하되, 그렇지 않을 경우 트랜잭션 없이 실행한다.
     *          - 트랜잭션 내부에서 동작시에는 하나의 트랜잭션으로 보나 별개로 실행시에는 트랜잭션일 필요가 없다.(단독실행시에는 트랜잭션 취급 X)
     *  NOT_SUPPORTED : 트랜잭션 없이 현재 메소드를 실행하고 진행중인 트랜잭션이 있으면 잠시 중단한다
     *          - 기존 트랜잭션이 있든 말든 트랜잭션 없이 실행
     *  MANDATORY : 반드시 트랜잭션을 걸고 현재 메소드를 실행하되 진행중인 트랜잭션이 있으면(? 없으면) 예외를 던진다.
     *          - 기존 트랜잭션이 필수, 기존 트랜잭션이 없으면 예외
     *  NEVER : 반드시 트랜잭션 없이 현재 메소드를 실행하되 진행중인 트랜잭션이 있으면 예외를 던진다.
     *          - 기존 트랜잭션이 없어야함, 있으면 예외(MANDATORY와 반대)
     *  NESTED : 진행중인 트랜잭션이 있으면 현재 메소드를 이 트랜잭션의 중첩트랜잭션 내에서 실행한다. 진행중인 트랜잭션이 없으면 새 트랜잭션을
     *           실행한다.
     *              - REQUIRED 방식을 가지고 중첩 루프(중첩 트랜잭션)내에 적용
     *           배치 실행 도중 처리 할 업무가 백만개라고 하면 10만개씩 끊어서 커밋하는 경우 중간에 잘못 되어도 중첩 트랜잭션을 롤백하면 전체가
     *           아닌 10만개만 롤백된다.
     *           세이브포인트를 이용하는 방식이다. 따라서 세이브포인트를 지원하지 않는 경우 사용 불가능하다.
     */

    /* 설명. 격리레벨 (동시성)
     *  DEFAULT : DB의 기본 격리 수준을 사용한다. 대다수는 READ_COMMITTED가 기본 격리 수준이다.
     *  READ_UNCOMMITTED : 다른 트랜젝션이 아직 커밋하지 않은 값을 다른 트랜젝션이 읽을 수 있다.
     *                     따라서 오염된 값을 읽거나, 재현 불가능한 값 읽기, 허상 읽기 등의 문제가 발생할 수 있다.(모든 동시성 문제 발생)
     *          - 커밋이 안된 값을 다른 트랜잭션에서 읽기 가능
     *  READ_COMMITTED : 트랜젝션이 다른 트랜젝션에서 커밋한 값만 읽을 수 있다.
     *                   오염된 값 읽기 문제는 해결되지만 재현 불가능한 값 읽기 및 허상읽기는 여전히 발생할 수 있다.(다른 로우 수정 및 추가는 막을 수 없다.)
     *          - 트랜잭션이 작업 중인 row에 대해서만 lock
     *  REPEATABLE_READ : 트랜젝션이 어떤 필드를 여러 번 읽어도 동일한 값을 읽도록 보장한다.
     *                    트랜젝션이 지속되는 동안에는 다른 트랜젝션이 해당 필드를 변경할 수 없다.
     *                    오염된 값 읽기, 재현 불가능한 값 읽기는 해결되지만 허상읽기는 여전히 발생할 수 있다.(다른 로우 추가는 막을 수 없다.)
     *          - 트랜잭션이 작업중인 테이블의 값이 조작되지 않도록 보장, but 추가되는 건 막지 못함
     *  SERIALIZABLE : 트랜젝션이 테이블을 여러 번 읽어도 정확히 동일한 로우를 읽도록 보장한다. 트랜젝션이 지속되는 동안에는
     *                 다른 트랜젝션이 해당 테이블에 삽입, 수정, 삭제를 할 수 없다.
     *                 동시성 문제는 모두 해소되지만 성능은 현저하게 떨어진다. (모든 동시성 문제는 막을 수 있다.)
     *          - 트랜잭션이 해당 테이블에서 작업을 하는 경우 다른 트랜잭션이 해당 테이블에 접근 자체를 못하게 막음 -> 동시성 해결 but 성능 저하
     * 설명.
     *  오염된 값(Dirty Read) :
     *           하나의 트랜젝션이 데이터를 변경 후 잠시 기다리는 동안 다른 트랜젝션이 데이터를 읽게 되면,
     *           격리레벨이 READ_UNCOMMITTED인 경우 아직 변경 후 커밋하지 않은 재고값을 그대로 읽게 된다.
     *           그러나 처음 트랜젝션이 데이터를 롤백하게 되면 다른 트랜젝션이 읽은 값은 더 이상 유효하지 않은 일시적인 값이 된다.
     *           이것을 오염된 값라고 한다.
     *      - 읽어온 값이 커밋이 되기 이전에 읽은 값이라 롤백이 되었을 경우 유효하지 않은 값 즉, 오염된 값이 된다.
     *  재현 불가능한 값 읽기(Non-Repeatable Read) :
     *                       처음 트랜젝션이 데이터를 수정하면 수정이 되고 아직 커밋되지 않은 로우에 수정 잠금을 걸어둔 상태에다.
     *                       결국 다른 트랜젝션은 이 트랜젝션이 커밋 혹은 롤백 되고 수정잠금이 풀릴 때까지 기다렸다가 읽을 수 밖에 없게 된다.
     *                       하지만 다른 로우에 대해서는 또 다른 트랜젝션이 데이터를 수정하고 커밋을 하게 되면
     *                       가장 처음 동작한 트랜젝션이 데이터를 커밋하고 다시 조회를 한 경우 처음 읽은 그 값이 아니게 된다.
     *                       이것이 재현 불가능한 값이라고 한다.
     *      - 트랜잭션 A가 처음 DML 작업을 할 때 작업중인 값은 못건드리나 건드리지 않은 테이블 값은 다른 트랜잭션 B가 값은 수정 가능
     *            즉, 트랜잭션 A가 다시 읽을 때 다른 값이 조회 -> 처음 조회했던 값은 DB에 없는 값이 되었으므로 '재현 불가능한 값' 이 된다.
     *  허상 읽기(Phantom Read) :
     *             처음 트랜젝션이 테이블에서 여러 로우를 읽은 후 이후 트랜젝션이 같은 테이블의 로우를 추가하는 경우
     *             처음 트랜젝션이 같은 테이블을 다시 읽으면 자신이 처음 읽었을 때와 달리 새로 추가 된 로우가 있을 것이다.
     *             이것을 허상 읽기라고 한다. (재현 불가능한 값 읽기와 유사하지만 허상 읽기는 여러 로우가 추가되는 경우를 말한다.)
     *      - 처음엔 없었던 값이 갑자기 조회되는 상황(로우가 추가되는 경우)
     */

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
