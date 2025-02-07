package com.ohgiraffers.section01.list.run;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application1 {
    public static void main(String[] args) {
        /* 수업목표. 컬렉션 프레임 워크에 대해 이해할 수 있다. */

        /* 설명. 모든 컬렉션은 제네릭 타입이며 다이아몬드 연산자(<>)를 생략하면 <Object>인 상태이다. */
//        ArrayList list = new ArrayList();
        List<Object> list = new ArrayList(); // List 계열은 다형성 적용 가능

        /* 설명. 데이터를 넣은 순서를 기억한다. */
        list.add("apple");
        list.add('a');
        list.add(1);
        list.add(2.5);
        list.add(new java.util.Date());

        /* 설명. 모든 컬렉션은 toString()이 잘 오버라이딩 되어 있어 쉽게 출력해 볼 수 있다. */
        System.out.println("list = " + list);

        System.out.println("첫 번째 요소: " + list.get(0));
        System.out.println("두 번째 요소: " + list.get(1));
        System.out.println("세 번째 요소: " + list.get(2));
        System.out.println("list에 담긴 데이터의 크기: " + list.size()); // 데이터를 몇 개 담고 있느냐

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        /* 설명
         *  배열보다 ArrayList가 좋은 점
         *  1. 미리 크기를 할당할 필요가 없다.
         *  2. 들어있는 값의 갯수를 잘 파악할 수 있다.(size())
         *  3. 경우에 따라(제네릭 타입을 생략하면) 다양한 타입의 값을 한 번에 저장할 수 있다.
         *  4. 중간에 값을 추가 및 삭제가 용이하다. (이미 구현된 기능들이 많다.)
         */

        list.add(1, 10); // 기존 arraylist의 1번 인덱스에 10 추가(기존 값들은 한 칸씩 뒤로 물러난다.)
        System.out.println("list = " + list);

        // Arraylist는 순서 개념이 있다. (중복 가능)
        list.add(10);
        System.out.println("list = " + list);

        // 해당 인덱스의 값 수정
        list.set(0, "집 가고 싶다.");
        System.out.println("list = " + list);

        // 해당 인덱스의 값 제거 (해당 인덱스 이후의 값은 한 칸씩 땡겨진다.)
        list.remove(0);
        System.out.println("list = " + list);

        /* 컬렉션 대신 배열로 한 번 중간에 값 추가 연습해 보기 */
        int[] intArr = new int[5];
        int num = 0;
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = ++num;
        }
        System.out.println(Arrays.toString(intArr));

        // 인덱스 1에 7을 넣어 보자
        int index = 1;
        int temp = 7;
        int[] newArr = new int[intArr.length + 1];
//        for (int i = 0; i < newArr.length; i++) {
//            if (i < index)
//                newArr[i] = intArr[i];
//            else if (i == index)
//                newArr[i] = temp;
//            else
//                newArr[i] = intArr[i - 1];
//        }

        System.arraycopy(intArr, 0, newArr, 0, index);
        newArr[index] = temp;
        System.arraycopy(intArr, 1, newArr, 2, intArr.length-index);

        System.out.println(Arrays.toString(newArr));

    }
}
