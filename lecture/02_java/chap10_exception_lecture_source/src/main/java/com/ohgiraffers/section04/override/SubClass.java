package com.ohgiraffers.section04.override;

import java.io.FileNotFoundException;
import java.io.IOException;

public class SubClass extends SuperClass {
    /* 설명. 부모 클래스를 기준으로 다형성을 적용하여 코드를 작성했을 경우
     *  정적 바인딩에서 동적 바인딩 되었을 떄 예외상황을 override 하는 경우
     */
    public void method2() throws FileNotFoundException {

    }

    /* 설명. 부모 메소드의 예외 클래스와 같은 레벨일 땐 문제 없음 */
//    @Override
//    public void method() throws IOException {
//
//    }

    /* 설명. 부모 메소드와 달리 예외를 발생시키지 않아도 문제 없음 */
//    @Override
//    public void method() {
//
//    }

    /* 설명. 부모 메소드보다 더 낮은 레벨을 발생시켜도 문제 X */
    // FileNotFoundException은 IOException의 자식이기에 IOException이 다룰 수 있기 때문
//    @Override
//    public void method() throws FileNotFoundException {
//
//    }

    /* 설명. 부모 메소드보다 더 높은 레벨을 발생시키면 컴파일 에러 발생 */
    // 부모의 IOException은 Exception을 다룰 수 없음
//    @Override
//    public void method() throws Exception{
//
//    }
}
