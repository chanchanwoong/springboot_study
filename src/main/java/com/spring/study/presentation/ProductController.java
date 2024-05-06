package com.spring.study.presentation;

import com.spring.study.application.ProductService;
import com.spring.study.data.dto.ProductDto;
import com.spring.study.data.vo.ChangeProductNameRequestVo;
import com.spring.study.data.vo.ProductResponseVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping()
    public ResponseEntity<ProductResponseVo> getProduct(long number) {
        ProductResponseVo productResponseVo = productService.getProduct(number);

        return ResponseEntity.status(HttpStatus.OK).body(productResponseVo);
    }

    @PostMapping()
    public ResponseEntity<ProductResponseVo> createProduct(@RequestBody ProductDto productDto) {
        ProductResponseVo productResponseVo = productService.saveProduct(productDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(productResponseVo);
    }

    @PutMapping()
    public ResponseEntity<ProductResponseVo> changeProductName(
        @RequestBody ChangeProductNameRequestVo changeProductNameRequestVo) throws Exception {
        ProductResponseVo productResponseVo = productService.changeProductName(changeProductNameRequestVo.getNumber(), changeProductNameRequestVo.getName());

        return ResponseEntity.status(HttpStatus.OK).body(productResponseVo);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteProduct(long number) throws Exception {
        productService.deleteProduct(number);

        return ResponseEntity.status(HttpStatus.OK).body("정상 삭제 되었습니다.");
    }
}
