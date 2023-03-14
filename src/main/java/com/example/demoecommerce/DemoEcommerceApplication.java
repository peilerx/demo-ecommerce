package com.example.demoecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class DemoEcommerceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoEcommerceApplication.class, args);
    }
}
