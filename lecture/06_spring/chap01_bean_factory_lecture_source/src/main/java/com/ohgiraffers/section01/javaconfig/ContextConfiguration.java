package com.ohgiraffers.section01.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 컨테이너를 만들기 위한 메타데이터
// 컨테이너에서 콩으로 해당 객체를 관리해준다.
@Configuration("config1")
public class ContextConfiguration {
    // 추가로 콩 만들 수 있는 방법
    @Bean("member") // 일종의 bean을 구분하는 id
    public MemberDTO getMember() {
        return new MemberDTO(2, "user02", "pass01", "홍길동");
    }
}
