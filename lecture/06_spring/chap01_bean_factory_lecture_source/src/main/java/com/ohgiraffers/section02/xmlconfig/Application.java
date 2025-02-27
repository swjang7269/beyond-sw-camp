package com.ohgiraffers.section02.xmlconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("section02/xmlconfig/spring-context.xml"); // resources로부터의 상대경로

        // 모든 bean은 싱글톤으로 관리된다.

        /* 설명. 컨테이너에 들어있는 모든 bean의 이름(id) */
        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }

        /* 설명. 1. bean의 id를 가지고 컨테이너에서 추출 */
        MemberDTO member = (MemberDTO)context.getBean("member");    // 반환형이 object
        System.out.println("member = " + member);

        /* 설명. 2. bean의 클래스의 메타 정보(bean의 타입)를 전달하여 추출 */
        // 동일한 타입의 bean이 여러개인 경우 설정을 통해 전부 추출할 수도, 하나만 추출할 수도 있다.
        MemberDTO member2 = context.getBean(MemberDTO.class);
        System.out.println("member2 = " + member2);

        /* 설명. 3. bean의 id와 클래스의 메타 정보를 전달하여 추출 */
        // 메타 정보도 함께 전달하여 다운 캐스팅을 할 필요가 없다.
        MemberDTO member3 = context.getBean("member", MemberDTO.class);
        System.out.println("member3 = " + member3);
    }
}
