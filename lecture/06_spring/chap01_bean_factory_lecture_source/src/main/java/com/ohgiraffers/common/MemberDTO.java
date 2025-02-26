package com.ohgiraffers.common;

import lombok.*;    // 코드를 어노테이션으로 대체

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MemberDTO {
    private int sequence;
    private String id;
    private String pwd;
    private String name;
}
