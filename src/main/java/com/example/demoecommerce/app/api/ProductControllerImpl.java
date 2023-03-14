package com.example.demoecommerce.app.api;

import com.example.demoecommerce.app.dto.ProductDto;
import com.example.demoecommerce.core.product.impl.ProductServiceImpl;
import com.example.demoecommerce.core.product.service.ProductService;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/")
public class ProductControllerImpl {
    private final ProductService productService;

    @Autowired
    public ProductControllerImpl(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/products")
    public List<ProductDto> getAll() {
        return productService.getAll();
    }

    @GetMapping("/product/{id}")
    public ProductDto getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @GetMapping("/product/search")
    public ProductDto getById(@RequestBody ProductDto productDto) {
        return productService.getById(productDto);
    }

    @PostMapping("/product/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto save(@RequestBody ProductDto productDto) {
        return productService.save(productDto);
    }
}
