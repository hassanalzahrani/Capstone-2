package com.example.demo.Controller;

import com.example.demo.Modell.Customer;
import com.example.demo.Service.CustomerService;
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
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/get")
    public ResponseEntity getAllCustomers() {
        return ResponseEntity.status(200).body(customerService.getAllCustomers());
    }

    @PostMapping("/add")
    public ResponseEntity addCustomer(@Valid @RequestBody Customer customer, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        customerService.saveCustomer(customer);
        return ResponseEntity.status(201).body("Customer added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCustomer(@PathVariable Integer id, @Valid @RequestBody Customer customer, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        customerService.updateCustomer(id, customer);
        return ResponseEntity.status(200).body("Customer updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.status(200).body("Customer deleted successfully");
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getCustomerById(@PathVariable int id) {
        return ResponseEntity.status(200).body(customerService.getCustomerById(id));
    }
    @GetMapping("get-by-name/{name}")
    public ResponseEntity getCustomerByName(@PathVariable String name) {
        return ResponseEntity.status(200).body(customerService.getCustomerByName(name));
    }
    @GetMapping("/get-by-phone/{phone}")
    public ResponseEntity getCustomerByPhone(@PathVariable String phone) {
        return ResponseEntity.status(200).body(customerService.getCustomerByPhone(phone));
    }
}
