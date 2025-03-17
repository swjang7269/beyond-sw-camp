package com.ohgiraffers.springdatajpa.menu.controller;

import com.ohgiraffers.springdatajpa.common.Pagination;
import com.ohgiraffers.springdatajpa.common.PagingButtonInfo;
import com.ohgiraffers.springdatajpa.menu.dto.MenuDTO;
import com.ohgiraffers.springdatajpa.menu.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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

    /* 설명. 페이징 처리 전 */
//    @GetMapping("/list")
//    public String findMenuList(Model model) {
//        List<MenuDTO> menuList = menuService.findMemberList();
//
//        model.addAttribute("menuList", menuList);
//
//        return "menu/list";
//    }

    /* 설명 페이징 처리 후 */
    /* 설명.
     *  @PageableDefault
     *   1. 기본 한 페이지에 10개의 데이터(size, value)
     *   2. 기본 1페이지 부터(0부터 index 개념)
     *   3. 기본 오름차순(ASC)
     */
    @GetMapping("/list")
    public String findMenuList(@PageableDefault Pageable pageable, Model model){
        log.debug("pageable = {}", pageable);

        Page<MenuDTO> menuList = menuService.findMemberList(pageable);

        log.debug("조회한 내용 목록: {}", menuList.getContent());
        log.debug("총 페이지 수: {}", menuList.getTotalPages());
        log.debug("총 메뉴 수: {}", menuList.getTotalElements());
        log.debug("해당 페이지에 표시 될 요소 수: {}", menuList.getSize());
        log.debug("해당 페이지에 실제 요소 수: {}", menuList.getNumberOfElements());

        /* 설명. Page객체를 통해 PagingButtonInfo 추출 */
        PagingButtonInfo paging = Pagination.getPagingButtonInfo(menuList);

        model.addAttribute("menuList", menuList);
        model.addAttribute("paging", paging);

        return "menu/list";
    }
}
