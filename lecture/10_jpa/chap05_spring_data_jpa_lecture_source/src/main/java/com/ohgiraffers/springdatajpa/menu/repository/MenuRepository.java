package com.ohgiraffers.springdatajpa.menu.repository;

import com.ohgiraffers.springdatajpa.menu.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaPepository<클래스타입, pk타입> -> 하위 구현체 자동 생성 및 bean으로 관리
public interface MenuRepository extends JpaRepository<Menu, Integer> {
}
