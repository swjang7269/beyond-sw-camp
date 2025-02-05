package com.ohgiraffers.section04.wrapper;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. Wrapper 클래스에 대해 이해할 수 있다. */
        int intValue = 20;


        /* 설명. 기본자료형을 Wrapper 클래스 자료형으로 변환할 수 있다.(박싱, boxing) */
        Integer autoBoxingInt = 20;                 // 오토 박싱(auto-boxing)
        Integer boxingInt2 = Integer.valueOf(intValue);

        System.out.println(intValue + autoBoxingInt); // 연산을 할 경우 주소 값 연산이 안되기에 오토 언박싱이 일어남
        System.out.println(intValue == autoBoxingInt);
        System.out.println(System.identityHashCode(intValue));      // 시스템적 주소가 같아서
        System.out.println(System.identityHashCode(autoBoxingInt)); // (==) 비교시 오토 언박싱이 일어날 필요도 없다.
        System.out.println(autoBoxingInt.equals(intValue)); // eqauls가 값을 비교하도록 오버라이딩 되어있음

        /* 설명. Wrapper 클래스 자료형을 기본자료형으로 변환할 수 있다.(언박싱, unboxing) */
        int autoUnboxingInt = autoBoxingInt;        // 오토 언박싱(auto-unboxing)
        int unboxingInt2 = boxingInt2.intValue();

        anythingMethod(20);

        /* 설명. Wrapper 클래스 주소값 비교 */
        Integer integerTest = 30;
        Integer integerTest2 = 30;
        System.out.println("== 비교: " + (integerTest == integerTest2));
        System.out.println("equals() 비교: " + integerTest.equals(integerTest2));
        System.out.println("integerTest 주소: " + System.identityHashCode(integerTest));

        /* 설명. 모든 Wrapper 클래스들도 constant pool을 활용해 동등 객체는 하나만(동일 인스턴스로) 저장한다. */
        System.out.println("integerTest2 주소: " + System.identityHashCode(integerTest2));
    }

    private static void anythingMethod(Object obj) {

        /* 설명. int -> Integer(오토박싱) -> Object(다형성) */
        /* 설명. 출력 -> Object의 toString()에서 Integer의 toString()(동적 바인딩)이 실행됨 */
        System.out.println("obj: " + obj.toString());
    }
}
