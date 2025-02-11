package com.ohgiraffers.section01.list.run;

import com.ohgiraffers.section01.list.comparator.AscendingPrice;
import com.ohgiraffers.section01.list.dto.BookDTO;
import java.util.*;

public class Application2 {
    public static void main(String[] args) {
        /* 수업목표. ArrayList에서 관리되는 자료형의 정렬 기준을 이해할 수 있다. */
        List<BookDTO> booklist = new ArrayList<>();

        /* BookDTO 객체(필드 4개)는 정렬 기준이 4 * 2 개 있다. */
        /* 목차. 1. Comparable 인터페이스 구현 방법 활용 */
        booklist.add(new BookDTO(1, "홍길동전", "허균", 30000));
        booklist.add(new BookDTO(2, "목민심서", "정약용", 50000));
        booklist.add(new BookDTO(3, "동의보감", "허준", 40000));
        booklist.add(new BookDTO(4, "삼국사기", "김부식", 50000));
        booklist.add(new BookDTO(5, "삼국유사", "일연", 50000));


        /* compareTo는 해당 객체의 기본 정렬을 정의 -> 해당 클래스 내부에 설정해놓는 기본 정렬 기준
         * 해당 클래스의 정렬 기준 말고도 추가적으로 사용자 설정 정렬 기준으로 정렬하고 싶다면
         * 클래스를 수정할 필요없이 외부에서 compare을 정의하여 해당 객체와 함께 넘겨주면
         * 외부에서 정의한 기준으로 정렬이 가능하다. -> compareTo에 비해 유연하고 유지보수가 더 편리하다.
         */
        Collections.sort(booklist);
//        Collections.sort(booklist, new AscendingPrice());

        /* 설명. List 계열도 sort 메소드를 쓸 수 있는데 Comparator를 구현한 클래스의 객체만 넘겨주면 된다. */
        booklist.sort(new AscendingPrice());

        for (int i = 0; i < booklist.size(); i++) {
            System.out.println(booklist.get(i));
        }
    }
}
