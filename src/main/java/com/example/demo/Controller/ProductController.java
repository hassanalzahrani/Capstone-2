package com.example.demo.Controller;

import com.example.demo.Api.ApiException;
import com.example.demo.Modell.Product;
import com.example.demo.Service.ProductService;
import jakarta.validation.Valid;
import jdk.jfr.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
        import java.util.List;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/get")
    public ResponseEntity getProducts() {
        return ResponseEntity.status(200).body(productService.getAllProducts());
    }

    @PostMapping("/add")
    public ResponseEntity addProduct(@Valid @RequestBody Product product, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        productService.addProduct(product);
        return ResponseEntity.status(200).body("Product added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@PathVariable int id, @Valid @RequestBody Product product, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        productService.updateProduct(id, product);
        return ResponseEntity.status(200).body("Product updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return ResponseEntity.status(200).body("Product deleted successfully");
    }

    @PostMapping("/add-to-cart{id}")
    public ResponseEntity<String> addProductToCart(@PathVariable Integer customerId, @RequestParam Integer productId, @RequestParam int quantity) {
        try {
            productService.addProductToCart(customerId, productId, quantity);
            return ResponseEntity.status(200).body("Product added to cart successfully");
        } catch (ApiException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @GetMapping("get-by-category/{category}")
   public ResponseEntity getProductsByCategory(@PathVariable String category) {
        return ResponseEntity.status(200).body(productService.getProductsByCategory(category));
    }
}
