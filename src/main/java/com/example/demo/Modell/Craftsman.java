package com.example.demo.Modell;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
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
public class Craftsman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @NotEmpty(message = "Craftsman PhoneNumber should no be empty")
  //  @Column(unique = true)
    //    @Column(nullable = false)

    private String craftmanPhoneNumber;
    @NotEmpty(message = " Craftsman Jop should no be empty")

    private String craftmanJop;
    @NotEmpty(message = "crafts name should no be empty")
    @Size(max = 20)
    private String craftsmanName;

    @Min(0)
    private double craftsmanRate;
}