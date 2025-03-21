package com.ohgiraffers.userservice.service;

import com.ohgiraffers.userservice.DTO.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    void registUser(UserDTO userDTO);

    UserDTO getUserById(String memNO);
}
