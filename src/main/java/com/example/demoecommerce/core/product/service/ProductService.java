package com.example.demoecommerce.core.product.service;

import com.example.demoecommerce.app.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto getById(ProductDto productDto);
    ProductDto getById(Long id);
    ProductDto save(ProductDto productDto);
    List<ProductDto> getAll();
}
