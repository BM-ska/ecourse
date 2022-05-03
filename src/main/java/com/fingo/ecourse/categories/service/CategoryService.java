package com.fingo.ecourse.categories.service;

import com.fingo.ecourse.categories.repository.CategoryDto;
import com.fingo.ecourse.categories.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
	private final CategoryRepository categoryRepository;

	public List<CategoryDto> getAllCategories() {
		return categoryRepository.getAll();
	}

	public CategoryDto saveCategory(CategoryDto category) {
		return categoryRepository.save(category);
	}
}
