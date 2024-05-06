package com.spring.study.application.impl;

import com.spring.study.application.ProductService;
import com.spring.study.data.dto.ProductDto;
import com.spring.study.data.vo.ProductResponseVo;
import com.spring.study.domain.Product;
import com.spring.study.infrastructure.dao.ProductDao;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    @Override
    public ProductResponseVo getProduct(long number) {
        Product prodct = productDao.selectProduct(number);

        ProductResponseVo productResponseVo = ProductResponseVo.builder()
            .number(prodct.getNumber())
            .name(prodct.getName())
            .price(prodct.getPrice())
            .stock(prodct.getStock())
            .build();

        return productResponseVo;
    }

    @Override
    public ProductResponseVo saveProduct(ProductDto productDto) {
        Product product = Product.builder()
            .name(productDto.getName())
            .price(productDto.getPrice())
            .stock(productDto.getStock())
            .createdAt(LocalDateTime.now())
            .updatedAt(LocalDateTime.now())
            .build();

        Product savedProduct = productDao.insertProduct(product);

        ProductResponseVo productResponseVo = ProductResponseVo.builder()
            .number(savedProduct.getNumber())
            .name(savedProduct.getName())
            .price(savedProduct.getPrice())
            .stock(savedProduct.getStock())
            .build();

        return productResponseVo;
    }

    @Override
    public ProductResponseVo changeProductName(long number, String name) throws Exception {
        Product changedProduct = productDao.updateProductName(number, name);

        ProductResponseVo productResponseVo = ProductResponseVo.builder()
            .number(changedProduct.getNumber())
            .name(changedProduct.getName())
            .price(changedProduct.getPrice())
            .stock(changedProduct.getStock())
            .build();

        return productResponseVo;
    }

    @Override
    public void deleteProduct(long number) throws Exception {
        productDao.deleteProduct(number);
    }
}
