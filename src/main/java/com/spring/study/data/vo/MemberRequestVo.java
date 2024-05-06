package com.spring.study.data.vo;

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
