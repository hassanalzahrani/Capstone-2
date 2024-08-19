package com.example.demo.Service;

import com.example.demo.Api.ApiException;
import com.example.demo.Modell.Craftsman;
import com.example.demo.Modell.JobReservation;
import com.example.demo.Modell.Review;
import com.example.demo.Repository.CraftsmanRepository;
import com.example.demo.Repository.CustomerRepository;
import com.example.demo.Repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CraftsmanService {
    private final CraftsmanRepository craftsmanRepository;
private final ReviewRepository reviewRepository;
private final CustomerRepository customerRepository;

  //===================================================

    public Craftsman saveCraftsman(Craftsman craftsman) {

        return craftsmanRepository.save(craftsman);
    }

    public List<Craftsman> getAllCraftsmen() {
        return craftsmanRepository.findAll();
    }

    public Craftsman getCraftsmanById(int id) {
        return craftsmanRepository.findById(id).orElseThrow(() -> new ApiException("Craftsman not found"));
    }

    public void deleteCraftsman(int id) {
        Craftsman craftsman = craftsmanRepository.findById(id).orElseThrow(() -> new ApiException("Craftsman not found"));
        craftsmanRepository.delete(craftsman);
    }

    public void updateCraftsman(int id, Craftsman craftsman) {
        Craftsman existingCraftsman = craftsmanRepository.findById(id).orElseThrow(() -> new ApiException("Craftsman not found"));
        existingCraftsman.setCraftsmanName(craftsman.getCraftsmanName());
        existingCraftsman.setCraftsmanRate(craftsman.getCraftsmanRate());
        craftsmanRepository.save(existingCraftsman);
    }

    public Craftsman getCraftsmanByName(String name) {
        return craftsmanRepository.findByCraftsmanName(name)
                .orElseThrow(() -> new RuntimeException("Craftsman with name " + name + " not found"));
    }

    public Craftsman getCraftsPhone(String phone) {
        return craftsmanRepository.findCraftsmanByCraftmanPhoneNumber(phone);
    }

//=======================================================================================

    public void addReview(Review review ) {
      Craftsman craftsman = getCraftsmanById(review.getCraftsmanId());
        if (!craftsmanRepository.existsById(review.getCraftsmanId())) {
            throw new IllegalArgumentException("Craftsman not found");
        }

        if (!customerRepository.existsById(review.getCustomerId())) {
            throw new IllegalArgumentException("Customer not found");
        }


        reviewRepository.save(review);
    }


}
