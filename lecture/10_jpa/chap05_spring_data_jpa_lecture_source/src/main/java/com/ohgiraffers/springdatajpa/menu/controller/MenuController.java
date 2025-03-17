package com.ohgiraffers.springdatajpa.menu.controller;

import com.ohgiraffers.springdatajpa.menu.dto.MenuDTO;
import com.ohgiraffers.springdatajpa.menu.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
@Slf4j  // Logger를 사용하기 위함
public class MenuController {
    private final MenuService menuService;
    /* 설명
     *  Logger를 활용한 로그 생성 이유?
     *   1. println보다 성능적으로 우수
     *   2. 외부 리소스 파일로 따로 저장 및 송출 가능
     *   3. 로그레벨에 따른 확인이 가능(개발: debug, 서비스: info)
     */
//    Logger logger = LoggerFactory.getLogger(MenuController.class);  // 로그를 찍기 위한 로거 할당
//    Logger logger = LoggerFactory.getLogger(getClass());  // 소속 클래스로 바로 할당 가능

    @Autowired
    public MenuController(MenuService menuService){
        this.menuService = menuService;
    }

    @GetMapping("/{menuCode}")  // 경로상의 변수를 받을 수 있다.
    public String findMenuByCode(@PathVariable int menuCode, Model model) {
//        logger.debug("menuCode = {}", menuCode);    // debug 레벨 로그를 찍기 위해 application.yml에 설정 추가
        log.debug("menuCode = {}", menuCode);   // 롬복을 활용하여 변수 선언 없이 바로 사용

        MenuDTO menu = menuService.findMenuByCode(menuCode);

        model.addAttribute("menu", menu);

        return "menu/detail";
    }
}
