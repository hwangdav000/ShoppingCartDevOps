package com.ecom.client;

import org.springframework.web.bind.annotation.*;

import com.ecom.model.Category;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;

import java.util.List;

@FeignClient(name = "SHOPPING-MICROSERVICE4", url = "http://${microservice4:localhost}:8094")
public interface CategoryClient {

    // Save a new category
    @PostMapping("/api/category/save")
    Category saveCategory(@RequestBody Category category);

    // Check if a category exists by name
    @GetMapping("/api/category/exists/{name}")
    Boolean existCategory(@PathVariable String name);

    // Get all categories
    @GetMapping("/api/category/all")
    List<Category> getAllCategory();

    // Delete a category by ID
    @DeleteMapping("/api/category/delete/{id}")
    Boolean deleteCategory(@PathVariable int id);

    // Get a category by ID
    @GetMapping("/api/category/{id}")
    Category getCategoryById(@PathVariable int id);

    // Get all active categories
    @GetMapping("/api/category/active")
    List<Category> getAllActiveCategory();

    // Get all categories with pagination
    @GetMapping("/api/category/pagination")
    Page<Category> getAllCategorPagination(@RequestParam(defaultValue = "0") Integer pageNo,
                                           @RequestParam(defaultValue = "10") Integer pageSize);
}
