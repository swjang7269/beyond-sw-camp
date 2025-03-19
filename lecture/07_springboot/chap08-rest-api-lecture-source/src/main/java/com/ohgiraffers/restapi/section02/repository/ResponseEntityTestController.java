package com.ohgiraffers.restapi.section02.repository;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpHeaders;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/entity")
public class ResponseEntityTestController {
    /* 설명.
     *  ResponseEntity란?
     *   HttpRequest를 응답하기 위해 httpEntity를 상속받아 HttpStatus, HttpHeaders, HttpBody를
     *   정의하여 사용하는 클래스
     */

    private List<UserDTO> users;

    public ResponseEntityTestController() {
        this.users = new ArrayList<>();
        users.add(new UserDTO(1, "user01", "pass01", "홍길동1", new java.util.Date()));
        users.add(new UserDTO(2, "user02", "pass02", "홍길동2", new java.util.Date()));
        users.add(new UserDTO(3, "user03", "pass03", "홍길동3", new java.util.Date()));
    }

    /* 설명. 1. ResponseEntity 생성자를 이용한 응답 */
//    public ResonseEntity<ResponseMessage> findAllUsers() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")))
//    }
}
