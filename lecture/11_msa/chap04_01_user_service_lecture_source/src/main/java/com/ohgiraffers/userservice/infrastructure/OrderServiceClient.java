package com.ohgiraffers.userservice.infrastructure;

import com.ohgiraffers.userservice.vo.ResponseOrder;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// 다른 도메인의 컨트롤러에게 요청
/* 설명. order-service와의 통신을 위한 클래스 */
/* 설명.
 *  1. FeignClient 관련 라이브러리 추가
 *  2. main가서 어노테이션 추가할 것(@EnableFeignClients)
 */

/* 설명. user-service가 order-service로 갈 때 token을 들고 가도록 설정을 만들어 추가 */
@FeignClient(name="swcamp-order-service", url="localhost:8000", configuration = FeignClientConfig.class)
public interface OrderServiceClient {
    @GetMapping("/order-service/users/{userId}/orders")   // orderService에서의 컨트롤러의 매핑과 일치하게 작성
    List<ResponseOrder> getUserOrders(@PathVariable String userId); // 다른 도메인의 반환값을 받아낼 타입 구조를 가지고 있어야 한다.
    // orderService에서 반환하는 responseVO를 받을 타입이 필요하다.
    // 다른 도메인으로 갈 떄 들고온 토큰을 그대로 들고가도록 설정 필요
}
