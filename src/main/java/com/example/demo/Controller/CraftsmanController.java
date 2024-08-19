package com.example.demo.Controller;
import com.example.demo.Modell.Craftsman;
import com.example.demo.Modell.Review;
import com.example.demo.Service.CraftsmanService;
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
@RequestMapping("api/v1/craftsmen")
public class CraftsmanController {

    private final CraftsmanService craftsmanService;

    @GetMapping("/get")
    public ResponseEntity getAllCraftsmen() {
        return ResponseEntity.status(200).body(craftsmanService.getAllCraftsmen());
    }

    @PostMapping("/add")
    public ResponseEntity addCraftsman(@Valid @RequestBody Craftsman craftsman, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        craftsmanService.saveCraftsman(craftsman);
        return ResponseEntity.status(201).body("Craftsman added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCraftsman(@PathVariable int id, @Valid @RequestBody Craftsman craftsman, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        craftsmanService.updateCraftsman(id, craftsman);
        return ResponseEntity.status(200).body("Craftsman updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCraftsman(@PathVariable int id) {
        craftsmanService.deleteCraftsman(id);
        return ResponseEntity.status(200).body("Craftsman deleted successfully");
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getCraftsmanById(@PathVariable int id) {
        return ResponseEntity.status(200).body(craftsmanService.getCraftsmanById(id));
    }

    @GetMapping("/get-by-name/{name}")
    public ResponseEntity getCraftsmanByName(@PathVariable String name) {
        Craftsman craftsman = craftsmanService.getCraftsmanByName(name);
        return ResponseEntity.status(200).body(craftsman);
    }

    @GetMapping("/get-by-phone/{phone}")
    public ResponseEntity getCraftsManByName(@PathVariable String phone) {
        return ResponseEntity.status(200).body(craftsmanService.getCraftsPhone(phone));
    }


    @PostMapping("/review")
    public ResponseEntity addReview(@Valid @RequestBody Review review) {
        craftsmanService.addReview(review);
        return ResponseEntity.status(201).body("Review added successfully");
    }
}

