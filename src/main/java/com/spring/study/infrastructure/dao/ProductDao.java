package com.spring.study.infrastructure.dao;

import com.spring.study.domain.Product;

public interface ProductDao {
    Product insertProduct(Product product);

    Product selectProduct(long number);

    Product updateProductName(Long number, String name) throws Exception;

    void deleteProduct(long number) throws Exception;

}
