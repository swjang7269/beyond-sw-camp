package com.ohgiraffers.userservice.aggregate;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="tbl_member")
public class UserEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Id")
    private long id;        // 회원 번호

    @Column(name="email", nullable=false, length=50, unique=true)
    private String email;   // 회원 이메일(아이디 대용)

//    @Column(name="pwd", nullable=false)
//    private String pwd;     // 비밀번호 -> 더이상 비밀번호는 매핑되지 않는다. 대신 encryptedPwd를 쓰겠다.

    @Column(name="encrypted_pwd", nullable=false)
    private String encryptedPwd;    // 암호화된 비밀번호

    @Column(name="name", nullable=false, length=50)
    private String name;    // 이름

    @Column(name="userId", nullable=false, unique = true)
    private String userId;  // 닉네임(서버에서 자동 생성한 고유id)

}
