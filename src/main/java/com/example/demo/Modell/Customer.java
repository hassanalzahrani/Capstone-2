package com.example.demo.Modell;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


    @Entity
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Customer {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Email
        @NotEmpty(message = "Customer Email  should not be empty")

        @Size(max = 40)
        private String customerEmail;
//        @Column(nullable = false)
        //  @Column(unique = true)

        @NotEmpty(message = "customer location should not be empty")
        @Size(max = 30)
        private String customerLocation;
//        @Column(nullable = false)
    @NotEmpty(message = "Customer Name should not be empty ")
        private String customerName;
      //  @Column(unique = true)
    @NotEmpty(message = "phone number should not be empty")
    private String phoneNumber;


    }

