package com.example.demo.Controller;

import com.example.demo.Modell.Bill;
import com.example.demo.Service.BillService;
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
@RequestMapping("api/v1/bills")
public class BillController {

    private final BillService billService;

    @GetMapping("/get")
    public ResponseEntity getAllBills() {
        return ResponseEntity.status(200).body(billService.getAllBills());
    }

    @PostMapping("/add")
    public ResponseEntity addBill(@Valid @RequestBody Bill bill, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        billService.saveBill(bill);
        return ResponseEntity.status(201).body("Bill added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBill(@PathVariable int id, @Valid @RequestBody Bill bill, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        billService.updateBill(id, bill);
        return ResponseEntity.status(200).body("Bill updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBill(@PathVariable int id) {
        billService.deleteBill(id);
        return ResponseEntity.status(200).body("Bill deleted successfully");
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getBillById(@PathVariable int id) {
        return ResponseEntity.status(200).body(billService.getBillById(id));
    }




}
