package com.spring.study.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class ProductDto {
    private String name;
    private int price;
    private int stock;
}
