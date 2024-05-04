package com.spring.study.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberRequestVo {
    private String name;
    private String email;
    private String organization;
}
