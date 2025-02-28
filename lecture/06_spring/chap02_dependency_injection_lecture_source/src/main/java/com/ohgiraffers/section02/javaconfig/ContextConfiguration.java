package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.Account;
import com.ohgiraffers.common.MemberDTO;
import com.ohgiraffers.common.PersonalAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {
    @Bean
    public Account accountGenerator() {
        return new PersonalAccount(20, "123-4567-87654");   // 다형성 적용 Account 타입의 bean이면서 PersonalAccount 타입의 bean
    }

    @Bean
    public MemberDTO memberGenerator() {
        /* 설명. setter 주입 */
        MemberDTO member = new MemberDTO();
        member.setSequence(1);
        member.setName("ara");
        member.setPhone("123-2123-1241");
        member.setEmail("ara@gmail.com");
        member.setPersonalAccount(accountGenerator());

        /* 설명. 생성자 주입 */
        member = new MemberDTO(2, "apsara", "123-123-1234", "apsara@gmail.com", accountGenerator());

        return member;
    }
}
