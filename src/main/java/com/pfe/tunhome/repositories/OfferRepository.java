package com.pfe.tunhome.repositories;

import com.pfe.tunhome.models.Offer;
import com.pfe.tunhome.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OfferRepository extends JpaRepository<Offer,Integer> {
}
