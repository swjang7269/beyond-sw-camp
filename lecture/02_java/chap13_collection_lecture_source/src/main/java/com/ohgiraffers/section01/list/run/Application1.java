package com.ohgiraffers.section01.list.run;

import java.util.*;

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
        System.arraycopy(intArr, 1, newArr, 2, intArr.length - index);

        System.out.println(Arrays.toString(newArr));

        /* 설명. ArrayList를 활용한 정렬 */
        /* 목차. 1. 문자열 데이터 정렬(feat.오름차순) */
        // 은닉화(hiding)
        // 타입 은닉(다형성)
        // 구현 은닉(인터페이스 활용)
        // 필드 및 메소드 은닉 (캡슐화 feat.private)

        // 사용 이유 -> 유지 보수의 용이성
//        List<String> stringList = new ArrayList<>();
        List<String> stringList = new LinkedList<>();       // 내림차순 할 때는 ㅣinkedList로 변경
        stringList.add("apple");                            // 타입 은닉화
        stringList.add("orange");                           // 실제 객체의 타입을 숨기고 코드 상에서 속이는 것
        stringList.add("grape");
        stringList.add("mango");
        stringList.add("banana");

        System.out.println(stringList);

        /* 설명. 실제로는 ArrayList 안에 있는 데이터인 String에 정의된 기준(오름차순)대로 정렬 */
        Collections.sort(stringList);
        System.out.println(stringList);

        /* 목차. 1-1. 문자열 데이터 내림차순 정렬 */
        /* 설명. 다루는 Iterator와 해당 컬렉션의 제네릭 타입은 왠만하면 꼭 명시하다.(feat. 다운 캐스팅 방지(타입 안정성)) */
        Iterator<String> iter = ((LinkedList<String>) stringList).descendingIterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
