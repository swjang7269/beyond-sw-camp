package com.ohgiraffers.section03.annotationconfig.subsection01.java;

import com.ohgiraffers.common.MemberDAO;
import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

// 동일 패키지 및 하위 폴더는 기본적으로 스캔하여 bean을 등록한다.
// 추가적인 범위 스캔을 위해서는 추가적인 설정이 필요하다.
// 해당 범위의 @Component 계열을 모두 탐색하여 bean으로 등록한다.

/* 설명
 *  section03에서는 ComponentScan과 관련하여 java클래스에서 @ComponentScan범위를
 *  bean으로 등록하는 방법을 다룬다.(실제 bean으로 등록할 때 자주 쓰는 어노테이션
 */
@Configuration

/* 설명. 1. 기본적으로는 설정파일에 있는 패키지 및 하위 폿더만 Scan하지만 basePackage를 바꾸면 다른 범위까지 가능 */
//@ComponentScan(basePackages = "com.ohgiraffers")      // bean 등록 후보 스캔을 할 범위 설정

/* 설명. 2. 범위 및 필터를 적용해서 제외하고자 하는 bean을 등록하는 경우(excludeFilters) */
// 아닌 것에 집중 - 블랙리스트 방식

@ComponentScan(basePackages = "com.ohgiraffers",
        excludeFilters = { @ComponentScan.Filter(
                /* 설명. 2-1. 타입으로 설정 */
                type = FilterType.ASSIGNABLE_TYPE,
                classes = {MemberDAO.class}

                /* 설명. 2-2. 어노테이션 종류로 설정 */
//                type = FilterType.ANNOTATION,
//                classes = {org.springframework.stereotype.Repository.class,}

                )
        })


/* 설명. 3. 범위 및 필터를 적용해서 등록하고자 하는 bean을 등록하는 경우(includeFilters) */
// 맞는 것에 집중 - 화이트리스트 방식
@ComponentScan(basePackages = {"com.ohgiraffers", "com"},
                useDefaultFilters = false,              // 현재 설정 파일 bean 제외 나머지 off
                includeFilters = {
                        @ComponentScan.Filter(
                                type=FilterType.ASSIGNABLE_TYPE,
                                classes = {MemberDAO.class}     // 원하는 타입의 bean만 살리기
                        )
                })
public class ContextConfiguration {
}
