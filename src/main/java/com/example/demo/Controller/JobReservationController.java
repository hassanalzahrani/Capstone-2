package com.example.demo.Controller;

import com.example.demo.Modell.JobReservation;
import com.example.demo.Service.JobReservationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/job-reservations")
public class JobReservationController {

    private final JobReservationService jobReservationService;

    @GetMapping("/get")
    public ResponseEntity getAllJobReservations() {
        return ResponseEntity.status(200).body(jobReservationService.getAllJobReservations());
    }

    @PostMapping("/add")
    public ResponseEntity addJobReservation(@Valid @RequestBody JobReservation jobReservation, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        jobReservationService.saveJobReservation(jobReservation);
        return ResponseEntity.status(201).body("Job reservation added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateJobReservation(@PathVariable int id, @Valid @RequestBody JobReservation jobReservation, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        jobReservationService.updateJobReservation(id, jobReservation);
        return ResponseEntity.status(200).body("Job reservation updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteJobReservation(@PathVariable int id) {
        jobReservationService.deleteJobReservation(id);
        return ResponseEntity.status(200).body("Job reservation deleted successfully");
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getJobReservationById(@PathVariable int id) {
        return ResponseEntity.status(200).body(jobReservationService.getJobReservationById(id));
    }


    @GetMapping("/get-by-type/{jopType}")
    public ResponseEntity getJobReservationsByType(@PathVariable String jopType) {
        List<JobReservation> jobReservations = jobReservationService.getJobReservationsByType(jopType);
        return ResponseEntity.status(200).body(jobReservations);
    }
    @GetMapping("/get-by-type/{jopTitle}")
    private ResponseEntity getJobReservationsByJopTitle(@PathVariable String jopTitle) {
        return ResponseEntity.status(200).body(jobReservationService.getAllJobReservationsByJopTitle(jopTitle));

    }
}

