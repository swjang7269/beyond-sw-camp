package com.ohgiraffers.section03.overriding;

public class SubClass extends SuperClass {
    /* 설명. 부모 메소드의 헤드부와 일치하게 오버라이딩 */
    @Override
    public void method1(int num) {
    }

    /* 설명. 메소드 이름 변경 (오버라이딩 안됨)
     *   feat.새로운 메소드를 생성한 것
     */
//    @Override
//    public void method(int num) {
//    }

    /* 설명. 메소드의 반환형(리턴 타입) 변경의 경우 (error) */
//    @Override
//    public String method1(int num) {
//        return null;
//    }

    /* 설명. 경우에 따라서는 메소드의 반환형을 달리 해도 오버라이딩이 성립.
     *  부모 반환형보다 작은 경우 가능 (부모 메소드 리턴 타입의 자식 타입으로는 가능)
     */
    // String은 Object의 자식 클래스이므로 오버라이딩 가능
    @Override
    public String method2(int num) {
        return null;
    }

    /* 설명. 부모 메소드가 private이라면 접근이 불가하므로 오버라이딩 불가 */
//    @Override
//    private void privateMethod() {}

    /* 설명. final 메소드의 경우 설령 public이라도 오버라이딩 불가 */
//    @Override
//    public final void finalMethod() {}

    /* 설명.
     *  다른 패키지더라도 protected의 경우는 상속관계이므로 오버라이딩 성립
     *  부모 메소드 접근 제어자와 같거나 더 큰 범위로는 오버라이딩 성립
     */
    @Override
//    protected void protectedMethod() {}
    public void protectedMethod() {}

    /* 설명. 같은 패키지 내에서만 오버라이딩 가능
     *  -> 다른 패키지에 있는 default 상속 불가능
     *      feat.새로 함수를 선언한 것
     */
    @Override
    void defaultMethod() {}
}
