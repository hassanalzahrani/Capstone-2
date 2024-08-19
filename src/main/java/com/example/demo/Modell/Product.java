package com.example.demo.Modell;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;


//        @Column(nullable = false)

    @NotEmpty(message = "Product name should not be empty")
    @Size(min = 4, max = 30, message = "Product Name must be more than 3 characters")
    private String Name;
//        @Column(nullable = false)

    @Positive(message = "Product Price must be Positive")
    private int Price;
//        @Column(nullable = false)

    @NotEmpty(message = "Category ID should not be empty")
    private String category;
//        @Column(nullable = false)

    @Positive(message = "Product Quantity must be positive")
    private int quantity;
}
