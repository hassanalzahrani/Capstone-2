package com.example.demo.Modell;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer billId;



    private int customerId;

    private int craftsmanId;

    @Min(0)
    private int cost;

    @Min(0)
    private int discount;


    @Pattern(regexp = "cash|credit")
    private String paymentType;
}