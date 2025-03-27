package com.ohgiraffers.transactional.section01.annotation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional  // 테스트 시 실제 DB에 반영되지 않도록(commit X) (But Autoincrement는 증가 -> 수동으로 다시 초기화)
class OrderServiceTest {
    @Autowired
    OrderService orderService;

    private static Stream<Arguments> getOrderInfo() {
        OrderDTO orderInfo = new OrderDTO();
        orderInfo.setOrderDate(LocalDate.now());
        orderInfo.setOrderTime(LocalTime.now());

//        List<OrderMenuDTO> orderMenuList = new ArrayList<>();
//        orderMenuList.add(new OrderMenuDTO(3, 10));
//        orderMenuList.add(new OrderMenuDTO(4, 10));
//        orderInfo.setOrderMenus(orderMenuList);
        orderInfo.setOrderMenus(List.of(new OrderMenuDTO(3, 5), new OrderMenuDTO(4, 10)));

        return Stream.of(Arguments.of(orderInfo));
    }

    @DisplayName("주문 등록 테스트")
    @ParameterizedTest
    @MethodSource("getOrderInfo")
    void testRegistNewOrder(OrderDTO orderInfo) {
        Assertions.assertDoesNotThrow(() -> orderService.registNewOrder(orderInfo));
    }

}