package com.example.demoecommerce.core.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    @ToString.Exclude
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Product name is required")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Product description is required")
    @Column(name = "description")
    private String description;

    @NotNull(message = "Product price is required")
    @DecimalMin("0.01")
    @Column(name = "price")
    private BigDecimal price;

    @NotNull(message = "Product quantity is required")
    @Min(0)
    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "imageUrl")
    private String imageUrl;
}