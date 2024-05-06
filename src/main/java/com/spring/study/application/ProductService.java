package com.spring.study.application;

import com.spring.study.data.dto.ProductDto;
import com.spring.study.data.vo.ProductResponseVo;

public interface ProductService {

    ProductResponseVo getProduct(long number);

    ProductResponseVo saveProduct(ProductDto productDto);

    ProductResponseVo changeProductName(long number, String name) throws Exception;

    void deleteProduct(long number) throws Exception;
}
