package com.ohgiraffers.userservice.Repository;

import com.ohgiraffers.userservice.aggregate.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);
}
