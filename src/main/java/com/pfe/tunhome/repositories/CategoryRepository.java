package com.pfe.tunhome.repositories;
import com.pfe.tunhome.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CategoryRepository extends JpaRepository <Category, Integer> {
}
