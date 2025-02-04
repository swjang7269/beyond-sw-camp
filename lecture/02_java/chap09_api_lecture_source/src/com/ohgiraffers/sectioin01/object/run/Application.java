package com.ohgiraffers.sectioin01.object.run;

import com.ohgiraffers.sectioin01.object.dto.BookDTO;

import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        BookDTO book1 = new BookDTO(1, "홍길동전", "허균", 50000);
        BookDTO book2 = new BookDTO(2, "홍길동전", "허균", 50000);

        System.out.println("두 인스턴스를 == 연산자로 비교: " + (book1 == book2));          // 동일 비교(주소 값이 같은지)

        System.out.println("두 인스턴스를 equals() 메소드로 비교: " + book1.equals(book2)); // 동등 비교가 되도록(number 달라도 되도록) 재정의(override)
        System.out.println("book1의 hashCode: " + book1.hashCode());
        System.out.println("book2의 hashCode: " + book2.hashCode());
    }
}
