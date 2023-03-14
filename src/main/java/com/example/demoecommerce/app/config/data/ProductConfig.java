package com.example.demoecommerce.app.config.data;

import com.example.demoecommerce.app.dto.ProductDto;
import com.example.demoecommerce.core.product.impl.ProductServiceImpl;
import com.example.demoecommerce.core.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Configuration
@Component
public class ProductConfig {
    ProductService productService;

    @Autowired
    ProductConfig(ProductServiceImpl productService){
        this.productService = productService;
    }

    @Bean
    public void initProducts(){
        ProductDto productDtoFirst = new ProductDto();
        productDtoFirst.setName("Dell Latitude 5480");
        productDtoFirst.setDescription("Dell Latitude 5480 is a Windows 10 Professional laptopdi with a 14.00-inch are powered by Intel HD Graphics.");
        productDtoFirst.setPrice(BigDecimal.valueOf(200.50));
        productDtoFirst.setQuantity(10);
        productDtoFirst.setImageUrl("https://images.prom.ua/4033513095_w640_h640_4033513095.jpg");
        productService.save(productDtoFirst);

        ProductDto productDtoSecond = new ProductDto();
        productDtoSecond.setName("HP EliteBook 840 g5");
        productDtoSecond.setDescription("HP EliteBook 840 G5 is a Windows 10 laptop with a 14.00-inch display");
        productDtoSecond.setPrice(BigDecimal.valueOf(350.50));
        productDtoSecond.setQuantity(15);
        productDtoSecond.setImageUrl("https://img.moyo.ua/img/category_text_images/images/c05914155.png");
        productService.save(productDtoSecond);
    }
}
