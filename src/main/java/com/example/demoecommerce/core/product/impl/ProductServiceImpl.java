package com.example.demoecommerce.core.product.impl;

import com.example.demoecommerce.app.dto.ProductDto;
import com.example.demoecommerce.core.product.Product;
import com.example.demoecommerce.core.product.service.ProductService;
import com.example.demoecommerce.core.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;

    @Autowired
    ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto getById(ProductDto productDto) {
        Product product = productRepository.getProductById(productDto.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setQuantity(product.getQuantity());
        productDto.setImageUrl(product.getImageUrl());
        return productDto;
    }

    @Override
    public ProductDto getById(Long id) {
        Product product = productRepository.getProductById(id);
        ProductDto productDto = new ProductDto();
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setQuantity(product.getQuantity());
        productDto.setImageUrl(product.getImageUrl());
        return productDto;
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());
        product.setImageUrl(productDto.getImageUrl());
        productRepository.save(product);
        return productDto;
    }

    @Override
    public List<ProductDto> getAll() {
        List<ProductDto> productsDtos = new ArrayList<>();
        if(productRepository.findAll().isEmpty()) {
            return null;
        }
        for (Product product : productRepository.findAll()) {
            ProductDto productDto = new ProductDto();
            productDto.setId(product.getId());
            productDto.setName(product.getName());
            productDto.setDescription(product.getDescription());
            productDto.setPrice(product.getPrice());
            productDto.setQuantity(product.getQuantity());
            productDto.setImageUrl(product.getImageUrl());
            productsDtos.add(productDto);
        }
        Collections.reverse(productsDtos);
        return productsDtos;
    }
}
