package com.example.demo.Modell;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

//        @Column(nullable = false)

    @Size(max = 30)
    private String jobTitle;
    @NotNull(message = "craftsManId name should no be empty")
//        @Column(nullable = false)

private int craftsManId;
    @NotNull(message = "craftsManId name should no be empty")
//        @Column(nullable = false)

    private int customerId;
    @Pattern(regexp = "service|cleaning|installation")
    private String jobType;

//        @Column(nullable = false)

    @NotNull(message = "Job Cost name should no be empty")
    @Min(0)
    private int jobCost;
//        @Column(nullable = false)

    @NotEmpty(message = "Job Description name should no be empty")
    @Size(max = 60)
    private String jobDescription;
//        @Column(nullable = false)


    @Pattern(regexp = "|yearly|one time")
    private String packageType;
}