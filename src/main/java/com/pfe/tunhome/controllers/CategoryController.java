package com.pfe.tunhome.controllers;


import com.pfe.tunhome.models.Category;
import com.pfe.tunhome.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("categories")
public class CategoryController {
    private CategoryRepository categoryRepository ;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @PostMapping(path = "add")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        Category savedCategory = this.categoryRepository.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }

    @GetMapping(path = "all")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = this.categoryRepository.findAll();
        return ResponseEntity.status(200).body(categories);
    }

    @DeleteMapping(path = "delete/{id}")
    public ResponseEntity<Map<String, Object>> deleteCategory(@PathVariable Integer id) {
        this.categoryRepository.deleteById(id);
        HashMap<String, Object> response = new HashMap<>();
        response.put("message", "category Deleted");
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping(path = "one/{id}")
    public ResponseEntity<Map<String, Object>> getcategoryById(@PathVariable Integer id) {
        HashMap<String, Object> response = new HashMap<>();

        try {
            Category category = this.categoryRepository.findById(id).get();
            response.put("data", category);

            return ResponseEntity.status(200).body(response);

        } catch (Exception e) {
            response.put("message", "category not found");
            return ResponseEntity.status(404).body(response);
        }
    }

    @PatchMapping(path = "update")

    public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
        Category savedCategory = this.categoryRepository.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }






}
