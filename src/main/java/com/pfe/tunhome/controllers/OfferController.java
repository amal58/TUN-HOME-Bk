package com.pfe.tunhome.controllers;

import com.pfe.tunhome.models.Offer;
import com.pfe.tunhome.repositories.OfferRepository;
import com.pfe.tunhome.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pfe.tunhome.models.Category;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("offers")
public class OfferController {

    private OfferRepository offerRepository;


    @Autowired
    public OfferController(OfferRepository offerRepository) {this.offerRepository=offerRepository;}

    @PostMapping(path ="add")
    public ResponseEntity<Offer> addOffer(@RequestBody Offer offer) {
        Offer savedOffer = this.offerRepository.save(offer);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOffer );
    }



    @GetMapping(path ="all")
    public ResponseEntity<List<Offer>> getAllOffer() {
        List<Offer> offers = this.offerRepository.findAll();
        return ResponseEntity.status(200).body(offers);
    }

    @DeleteMapping(path = "delete/{id}")
    public ResponseEntity<Map<String, Object>> deleteOffer(@PathVariable Integer id) {
        this.offerRepository.deleteById(id);
        HashMap<String, Object> response = new HashMap<>();
        response.put("message", "offer Deleted");
        return ResponseEntity.status(200).body(response);
    }


    @GetMapping(path = "one/{id}")
    public ResponseEntity<Map<String, Object>> getofferById(@PathVariable Integer id) {
        HashMap<String, Object> response = new HashMap<>();

        try {
            Offer offer = this.offerRepository.findById(id).get();
            response.put("data", offer);

            return ResponseEntity.status(200).body(response);

        } catch (Exception e) {
            response.put("message", "offer not found");
            return ResponseEntity.status(404).body(response);
        }
    }


    @PatchMapping(path = "update")

    public ResponseEntity<Offer> updateOffer(@RequestBody Offer offer) {
        Offer savedOffer = this.offerRepository.save( offer);
        return ResponseEntity.status(HttpStatus.CREATED).body( savedOffer);
    }





}
