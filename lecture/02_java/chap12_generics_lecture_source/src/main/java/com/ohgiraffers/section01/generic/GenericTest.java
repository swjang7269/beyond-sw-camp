package com.ohgiraffers.section01.generic;

// 객체를 생성할 때 T의 타입이 지정된다.
/* 설명.
 *  제네릭 클래스의 다이아몬드 연산자(<>)에 들어갈 수 있는 4가지 타입(기능은 같고 의미만 부여한 네이밍 컨밴션(가독성))
 *  1. E: Element
 *  2. T: Type
 *  3. K: Key
 *  4. V: Value
 */
public class GenericTest<T> {
    private T value;

    public GenericTest(){
    }

    public T getValue(){
        return value;
    }

    public void setValue(T value){
        this.value = value;
    }
}
