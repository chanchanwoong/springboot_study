package com.spring.study.infrastructure.dao.impl;

import com.spring.study.domain.Product;
import com.spring.study.infrastructure.ProductRepository;
import com.spring.study.infrastructure.dao.ProductDao;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductDaoImpl implements ProductDao {
    private final ProductRepository productRepository;
    @Override
    public Product insertProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    @Override
    public Product selectProduct(long number) {
        Product selectedProduct = productRepository.findById(number).get();
        return selectedProduct;
    }

    @Override
    @Transactional
    public Product updateProductName(Long number, String name) throws Exception {
        Optional<Product> selectedProduct = productRepository.findById(number);

        Product product;
        if (selectedProduct.isPresent()) {
            product = selectedProduct.get();

//            product.setName(name);
//            product.setUpdatedAt(LocalDateTime.now());

            // 갱신에 setter 방식을 대체하기 위해 엔티티 내에 메서드를 설정
            product.updateName(name);

            return product;
        } else {
            throw new Exception();
        }
    }

    @Override
    public void deleteProduct(long number) throws Exception {
        Optional<Product> selectedProduct = productRepository.findById(number);

        if (selectedProduct.isPresent()) {
            Product product = selectedProduct.get();
            productRepository.delete(product);
        } else {
            throw new Exception();
        }
    }
}
