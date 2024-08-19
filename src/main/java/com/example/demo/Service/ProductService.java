package com.example.demo.Service;

import com.example.demo.Api.ApiException;
import com.example.demo.Modell.Customer;
import com.example.demo.Modell.Product;
import com.example.demo.Repository.CustomerRepository;
import com.example.demo.Repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void updateProduct(Integer id, Product product) {
        Product p = productRepository.findProductByID(id);
        if (p == null) {
            throw new ApiException("Product not found");
        }

        p.setName(product.getName());
        p.setPrice(product.getPrice());
        p.setCategory(product.getCategory());
        productRepository.save(p);
    }

    public void deleteProduct(Integer id) {
        Product p = productRepository.findProductByID(id);
        if (p == null) {
            throw new ApiException("Product not found");
        }
        productRepository.delete(p);
    }


    private final CustomerRepository customerRepository;

////===========================================================================================
    public void addProductToCart(Integer customerId, Integer productId, int quantity) {
        if (customerId == null) {
            throw new ApiException("Customer ID cannot be null");
        }

        if (productId == null) {
            throw new ApiException("Product ID cannot be null");
        }

        if (quantity <= 0) {
            throw new ApiException("Quantity must be greater than zero");
        }

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ApiException("Customer not found"));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ApiException("Product not found"));

        System.out.println("Added product " + productId + " to customer " + customerId + "'s cart with quantity " + quantity);
    }

    ///===============================

    public List<Product> getProductsByCategory(String category) {
        return productRepository.findProductByCategory(category);
    }
}

