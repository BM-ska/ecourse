package com.fingo.ecourse.categories.controller;

import com.fingo.ecourse.categories.repository.CategoryEntity;
import com.fingo.ecourse.categories.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Piotr Stoklosa
 * @author Kacper Kingsford
 */
@RestController
@RequestMapping("api/v1/category")
@AllArgsConstructor

public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public Iterable<CategoryEntity> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping(consumes = "application/json")
    public CategoryEntity saveCategory(@RequestBody CategoryEntity category) {
        return categoryService.saveCategory(category);
    }
}
