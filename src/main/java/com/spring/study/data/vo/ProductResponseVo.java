package com.spring.study.data.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class ProductResponseVo {
    private long number;
    private String name;
    private int price;
    private int stock;
}
