package com.fingo.ecourse.categories.service;

import com.fingo.ecourse.categories.repository.CategoryEntity;
import com.fingo.ecourse.categories.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Piotr Stoklosa
 * @author Kacper Kingsford
 */
@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Iterable<CategoryEntity> getAllCategories() {
        return categoryRepository.findAll();
    }

    public CategoryEntity saveCategory(CategoryEntity category) {
        return categoryRepository.save(category);
    }
}
