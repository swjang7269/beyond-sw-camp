package com.ohgiraffers.section01.autowired.subsection03.constructor;

import com.ohgiraffers.section01.common.BookDAO;
import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "bookServiceConstructor")
public class BookService {
    // 생성자 주입 사용 시 final 사용 가능 -> 의존 관계가 세팅된 채로 실행이 정상적으로 되는지 조회 가능
    // 해당 bookDAO가 생성자 호출 시 대입된 값과 동일할 것임을 보장 (런타임시 오염 방지)
    private final BookDAO bookDAO;

    // 생성자 주입을 쓰는 이유 -> setter 사용을 지양하고 불변 객체를 지향하기 위해(유지보수성 향상)
    /* 설명.
     *  BookDAO 타입의 빈 객체를 생성자를 통해 주입 받는다.
     *   (@Autowired를 생성자에 작성하고 주입 받을 타입의 bean을 매개변수로 작성한다.) -> 기본 생성자 X
     *
     * 설명.
     *  생성자 주입의 이점
     *   1. 필드에 final 키워드를 사용할 수 있다.(런타임 오염 방지)
     *   2. 순환 잠조(스택오버플로우 야기)를 스프링 시작(컨테이너 생성 시)과 동시에 확인하고 에러를 발생시켜 준다.
     *      (다른 테이블과의 통신과정에서 발생(서로가 서로를 호출하는 경우)하는 연결(에러 혹은 스택오버플로우)
     *   3. field 주입 및 setter 주입의 단점을 보완
     *       - 필드 주입은 간결하지만 남용할 수 있고 이후에 setter가 없이는 수정이 불가능하다.
     *       - setter 주입은 불변 객체를 만들고자 함에 있어 문제가 발생할 수 있으며 객체의 변경이
     *           필요할 때만 setter를 추가하는 것이 맞다.(가급적 변경의 여지를 남기지 않아야 한다.)
     *   4. 테스트 코드 작성이 용이하다.(mock 객체 주입 용이)
     */
    @Autowired
    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public List<BookDTO> findAllBook() {
        return bookDAO.findAllBook();
    }

    public BookDTO findBookBySequence(int sequence) {
        return bookDAO.findBookBySequence(sequence);
    }
}
