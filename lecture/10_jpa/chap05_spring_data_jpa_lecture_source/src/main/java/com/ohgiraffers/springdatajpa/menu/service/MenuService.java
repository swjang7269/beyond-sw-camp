package com.ohgiraffers.springdatajpa.menu.service;

import com.ohgiraffers.springdatajpa.menu.dto.MenuDTO;
import com.ohgiraffers.springdatajpa.menu.entity.Menu;
import com.ohgiraffers.springdatajpa.menu.repository.MenuRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class MenuService {
    private final MenuRepository menuRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public MenuService(MenuRepository menuRepository, ModelMapper modelMapper) {
        this.menuRepository = menuRepository;
        this.modelMapper = new ModelMapper();
    }

    /* 설명. findById() */
    public MenuDTO findMenuByCode(int menuCode) {
        Menu menu = menuRepository.findById(menuCode).orElseThrow(IllegalArgumentException::new);    // 상속한 인터페이스에 구현되어 있는 함수 사용
        log.debug("menu: {}", menu);

        return modelMapper.map(menu, MenuDTO.class);   // Entity -> DTO
    }

    /* 설명. findAll() (paging 처리 X) */
    public List<MenuDTO> findMemberList() {
        List<Menu> menus = menuRepository.findAll(Sort.by("menuCode").descending());

        return menus.stream().map(menu -> modelMapper.map(menu, MenuDTO.class)).collect(Collectors.toList());
    }

    /* 설명. findAll() (paging 처리 O) */
    public Page<MenuDTO> findMemberList(@PageableDefault Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() -1,
                                    pageable.getPageSize(), Sort.by("menuCode").descending());

        return menuRepository.findAll(pageable).map(menu -> modelMapper.map(menu, MenuDTO.class));
    }
}
