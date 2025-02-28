package com.ohgiraffers.section01.autowired.subsection01.field;

import com.ohgiraffers.section01.common.BookDAO;
import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    // 필드 주입    Repository의 BookDAOImpl을 bean으로 만들어 Service단의 BookDAO에 주입
    // BookDAO 타입의 bean이 있는지 탐색 -> BookDAOImpl은 BookDAO 타입이기도 하여 Impl이 주입된다.

    // 객체를 따로 생성하거나 대입할 필요 없이 외부에서 생성된 객체를 주압받는 것 -> 의존성 주입(Dependency injection)
    /* 설명.
     *  아래의 세 가지는 ComponentScan 범위 안에 어노테이션이 달렸을 때 유효하다.
     *   1. @Service에 의해서 BookService 타입의 bookService id의 been이 관리된다.
     *   2. BookDAOImpl에 있는 @Repository에 의해서 bookDAOImpl id의 bean이 관리된다.(BookDAO 타입이기도 하다)
     *   3. @AutoWired에 의해서 bookDAO 타입의 bean이 BookService의 필드인 bookDAO 필드에 주입(대입)된다.(= 필드주입)
     */
    @Autowired
    private BookDAO bookDAO;    // ComponentScan 범위 내에 BookDAO 타입의 bean이 존재

    /* 설명. 도서 목록 전체 조회 */
    public List<BookDTO> findAllBook() {
        return bookDAO.findAllBook();
    }

    /* 설명. 도서 번호로 도서 조회 */
    public BookDTO findBookBySequence(int sequence) {
        return bookDAO.findBookBySequence(sequence);
    }
}
