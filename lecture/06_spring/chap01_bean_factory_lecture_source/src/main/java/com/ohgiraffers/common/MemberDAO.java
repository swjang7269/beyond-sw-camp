package com.ohgiraffers.common;

import org.springframework.stereotype.Repository;
// @Component(=bean으로 관리하라)를 가지고 있는 @Controller, @Service, @Repository 등은 bean으로 자동 등록되며 관리한다.
@Repository // 감지 설정 범위 내에 해당 어노테이션(@Component 계열)을 달면 bean으로 관리한다.
public class MemberDAO {

}
