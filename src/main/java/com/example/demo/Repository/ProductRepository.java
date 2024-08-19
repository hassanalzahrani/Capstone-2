package com.example.demo.Repository;

import com.example.demo.Modell.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findProductByID(int id);

    public List<Product> findProductByCategory(String category);
}
