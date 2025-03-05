package com.ohgiraffers.section02.reflection;

import java.lang.reflect.*;

public class Application {
    public static void main(String[] args) {
        /* 설명.
         *  리플렉션(reflection) 이란?
         *   컴파일 된 자바 코드에서 역으로 클래스를 불러 메소드 및 필드 정보를 구해오는 방법이다.
         *   스프링 프레임워크, 마이바티스, 하이버네이트, jackson 등의 라이브러리에서 사용된다.
         */
        // 런타임(Run-time)에 클래스, 메서드, 필드, 생성자 등의 정보를 조회하고 동적으로 조작할 수 있는 기능
        // 즉, 컴파일 시점이 아니라 실행 중에 객체의 정보를 읽고 수정할 수 있도록 하는 Java의 강력한 기능

        /* 설명. 1. Class 타입의 Class 메타정보 추출 */
        // 클래스 타입 추출
        Class class1 = Account.class;
        System.out.println("class1 = " + class1);

        Class class2 = new Account().getClass();
        System.out.println("class2 = " + class2);

        try {
            Class class3 = Class.forName("com.ohgiraffers.section02.reflection.Account");
            System.out.println("class3 = " + class3);

            Class class4 = Class.forName("[D");
            System.out.println("class4 = " + class4);

            Class class5 = double[].class;
            System.out.println("class5 = " + class5);

            Class class6 = Class.forName("[Ljava.lang.Double;");
            System.out.println("class6 = " + class6);

            Class class7 = String[].class;
            System.out.println("class7 = " + class7);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        /* 설명. 2. 필드 정보 추출 */
        // private여도 접근이 가능하다. -> 남용 주의
        Field[] fileds = Account.class.getDeclaredFields();
        for (Field field : fileds) {
            System.out.println("modifieres: " + Modifier.toString(field.getModifiers())
            + " name: " + field.getName()
            + " type: " + field.getType());
        }

        /* 설명. 3. 생성자 정보 추출 */
        Constructor[] constructors = Account.class.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("name: " + constructor.getName());

            // 파라미터 추출
            Class[] params = constructor.getParameterTypes();
            for (Class param : params) {
                System.out.println("parameterType: " + param.getTypeName());
            }
        }

        /* 설명. reflection 기술로 추출한 생성자만 별도로 취급하여 객체를 생성할 수도 있다. */
        // new 연산자를 활용하지 않고도 객체를 생성할 수 있다.
        try {
            Account acc = (Account) constructors[0].newInstance("20", "111-1111-1111", "1234", 30000);

            System.out.println(acc.getBalance());
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        /* 설명. 4. 메소드 정보 추출 */
        Method[] methods = Account.class.getMethods();
        Method getBalanceMethod = null;
        for (Method method : methods) {
//            System.out.println(Modifier.toString(method.getModifiers()));
            System.out.println("method: " + method.getName());

            if ("getBalance".equals(method.getName())) {
                getBalanceMethod = method;
            }
        }

        try {
            /* 설명. non-static 메소드만 따로 실행하고 싶을 땐 해당 메소드가 실행되기 위한 객체를 넘겨서 실행할 수 있다. */
            System.out.println(
                    getBalanceMethod.invoke(((Account)constructors[2].newInstance()))
            );

        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }
    }
}
