package com.ohgiraffers.section01.autowired.subsection03.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.section01");

        BookService bookService = context.getBean("bookServiceConstructor", BookService.class);

        bookService.findAllBook().forEach(System.out::println);
        System.out.println(bookService.findBookBySequence(2));
    }
}
