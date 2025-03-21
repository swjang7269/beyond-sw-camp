package com.ohgiraffers.userservice.controller;

import com.ohgiraffers.userservice.service.UserService;
import com.ohgiraffers.userservice.vo.RequestRegistUserVO;
import com.ohgiraffers.userservice.vo.ResponseFindUserVO;
import com.ohgiraffers.userservice.vo.ResponseRegistUserVO;
import com.ohgiraffers.userservice.DTO.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class UserController {
    private Environment env;
    private UserService userService;
    private ModelMapper modelMapper;

    public UserController(Environment env, UserService userService, ModelMapper modelMapper) {
        this.env = env;
        this.userService = userService;
        this.modelMapper = new ModelMapper();
    }

    @GetMapping("/health")
    public String status() {
        return "I'm Working in User Service " + env.getProperty("local.server.port");
    }

    @PostMapping("/users")
    public ResponseEntity<ResponseRegistUserVO> registUser(@RequestBody RequestRegistUserVO newUser) {
        UserDTO userDTO = modelMapper.map(newUser, UserDTO.class);

        /* 설명. call by reference 개념 */
        userService.registUser(userDTO); // service 가기 전과 후가 같은 객체이므로 반환할 필요가 없다.
        ResponseRegistUserVO successRegistUser = modelMapper.map(userDTO, ResponseRegistUserVO.class);

        return ResponseEntity.status(HttpStatus.OK).body(successRegistUser);
    }

    @GetMapping("/users/{memNo}")
    public ResponseEntity<ResponseFindUserVO> getUsers(@PathVariable String memNO) {
        UserDTO userDTO = userService.getUserById(memNO);

        ResponseFindUserVO findUserVO = modelMapper.map(userDTO, ResponseFindUserVO.class);

        return ResponseEntity.status(HttpStatus.OK).body(findUserVO);
    }

    @GetMapping("/test")
    public String test(@Value("${test.message}") String message) {
        return message;
    }
}
