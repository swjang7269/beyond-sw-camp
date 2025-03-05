package com.ohgiraffers.section01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class LoggingAspect {
    /* 설명.
     *  타겟 클래스의 메소드에서 어드바이스를 적용할 수 있는 지점들을 조인포인트(joinpoint)라고 한다.
     *  포인트컷(pointcut)은 여러 조인포인트들에 어드바이스(advice)를 적용할 곳을 지정한 것이다
     *  해당 조인포인트에서 어드바이스가 동작한다.
     *
     * 설명.
     *  <포인트컷 표현식>
     *  execution([수식어] 리턴타입 [클래스이름].이름(파라미터))
     *  1. 수식어: public, private 등 수식어를 명시(생략 가능)
     *  2. 리턴 타입: 리턴 타입을 명시
     *  3. 클래스 이름(패키지명 포함) 및 메소드 이름: 클래스이름과 메소드 이름을 명시
     *  4. 파라미터(매개변수): 메소드의 파라미터를 명시
     *  5. " * ": 1개이면서 모든 값이 올 수 있음
     *  6. " .. ": 0개 이상의 모든 값이 올 수 있음
     *
     * 설명.
     *  ex)
     *   execution(public Integer com.ohgiraffers.section01.advice.*.*(*))
     *   => com.ohgiraffers.section01.advice 패키지에 속해 있는 바로 다음 하위 클래스에 파라미터가 1개인 모든 메소드
     *      이자 접근 제어자가 public이고 반환형이 Integer인 경우
     *   execution(* com.ohgiraffers.section01.advice.annotation..stu*(..))
     *   => com.ohgiraffers.section01.advice 패키지 및 하위 패키지에 속해 있고 이름이 stu로 시작하는 파라미터가 0개
     *      이상인 모든 메소드이며 접근제어자와 반환형은 상관 없음
     *
     */

    /* 설명. 포인트컷 표현식을 재활용 하고자 할 때는 메소드로 따로 빼서 @Pointcut을 활용 */
    @Pointcut("execution(* com.ohgiraffers.section01.aop.*Service.*(..))")  // advice가  동작할 곳
    public void loggingAspect(){
    }

    /* 설명. 1. Before Advice */
//    @Before("execution(* com.ohgiraffers.section01.aop.*Service.*(..))")
    @Before("LoggingAspect.loggingAspect()")    // pointcut을 이용하여 요약 가능
    public void logBefore(JoinPoint joinPoint){
        System.out.println("Before Advice");
        System.out.println("Before joinPoint.getTarget(): " + joinPoint.getTarget());   // 타겟 객체(bean 객체)
        System.out.println("Before joinPoint.getSignature(): " + joinPoint.getSignature()); // 타겟 메소드
        if(joinPoint.getArgs().length > 0) {
            System.out.println("Before joinPoint.getARgs()[0]: " + joinPoint.getArgs()[0]);
        }
    }

    /* 설명. 2. After Advice */
    @After("LoggingAspect.loggingAspect()")
    public void logAfter(JoinPoint joinPoint){
        System.out.println("After Advice");
        System.out.println("After joinPoint.getTarget(): " + joinPoint.getTarget());   // 타겟 객체(bean 객체)
        System.out.println("After joinPoint.getSignature(): " + joinPoint.getSignature()); // 타겟 메소드
        if(joinPoint.getArgs().length > 0) {
            System.out.println("After joinPoint.getARgs()[0]: " + joinPoint.getArgs()[0]);
        }
    }

    /* 설명. 3. AfterReturning Advice */ // 반환형 존재
    /* 설명. Pointcut에 해당하는 위치가 담긴 메소드가 같은 클래스에 있으면 클래스 소속 생략 가능 */
    /* 설명. returning에 쓰인 이름이 반환값이 넘어올 때의 이름이고 매개변수와 일치해야 한다.(result) */
    @AfterReturning(pointcut = "loggingAspect()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("After Returning result: "+ result);

        if(result != null && result instanceof List) {
            ((List<MemberDTO>) result).add(new MemberDTO(3, "반환 값 가공"));
        }
    }

    /* 설명. 4. AfterThrowing Advice */
    /* 설명. 어노테이션의 .throwing 속성과 어드바이스의 매개변수 이름이 일치해야 함(exception) */
    @AfterThrowing(pointcut = "loggingAspect()", throwing = "exception")
    public void logAfterThrowing(Throwable exception) {
        System.out.println("After Throwing exception: "+ exception);
    }

    /* 설명. 5. Around Advice */  // 반환형 존재(Object 타입)
    /* 설명.
     *  이 어드바이스는 타겟 메소드를 완전히 장악하기 때문에 앞서 살펴본 어드바이스 모두
     *  Around Advice 하나로 대체가 가능하다.
     *  타겟 메소드를 언제 실행할지, 아니면 아예 실행을 안할지 여부도 제어한다.(필터와 유사)
     *  하지만 타겟 메소드를 실행하는 proceed() 메소드를 잊는 경우가 자주 발생하기 때문에 사용 시
     *  주의해야 하며 가능한 최소한의 요건을 충족하면서도 가장 약한 어드바이스를 쓰는 것이 바람직하다.
     */
    @Around("loggingAspect()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around Before");

        // target 동작(실행된 타겟 메소드를 반환해주어야한다.)
        Object result = joinPoint.proceed();

        System.out.println("Around After");

        /* 설명. 실행된 타겟 메소드를 반환(다른 어드바이스가 다시 실행될 수 있다.) */
        return result;
    }
}
