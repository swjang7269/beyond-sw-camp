package com.ohgiraffers.firstservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

//@RequestMapping("/first-service") // 게이트웨이에서의 필터 설정에서 접두사를 가공처리하여 결합도를 낮추서 더이상 필요 없다.
@RestController
@Slf4j
public class FirstServiceController {

    private Environment env;

    @Autowired
    public FirstServiceController(Environment env) {
        this.env = env;
    }

    @GetMapping("/health")
    public String healthCheck() {
        /* 설명. Environment를 활용해서 local.server.port를 가져오면 동적으로 할당된 실제 포트 번호 확인 가능 */
        return "OK, PORT: " + env.getProperty("local.server.port");
    }

    @GetMapping("/message")
    public String message(@RequestHeader("first-request") String header) {
        log.info("넘어온 헤더값: {}", header);

        return "First Service Message";
    }
}
