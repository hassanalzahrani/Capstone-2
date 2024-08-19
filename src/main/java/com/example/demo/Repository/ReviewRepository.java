package com.example.demo.Repository;

import com.example.demo.Modell.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface ReviewRepository extends JpaRepository<Review, Integer> {
        List<Review> findByCraftsmanId(int craftsmanId);
    }

