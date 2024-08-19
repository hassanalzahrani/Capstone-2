package com.example.demo.Repository;

import com.example.demo.Modell.Craftsman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface CraftsmanRepository extends JpaRepository<Craftsman, Integer> {

    Craftsman findCraftsmanById(Integer id);

    Optional<Craftsman> findByCraftsmanName(String name);

    Craftsman findCraftsmanByCraftmanPhoneNumber(String phoneNumber);

    List<Craftsman> findByAverageRatingBetween(int minRating, int maxRating);


}
