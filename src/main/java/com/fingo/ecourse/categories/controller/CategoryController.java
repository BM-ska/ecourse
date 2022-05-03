package com.fingo.ecourse.categories.controller;

import com.fingo.ecourse.categories.repository.CategoryDto;
import com.fingo.ecourse.categories.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/category")
@AllArgsConstructor
public class CategoryController {
	private final CategoryService categoryService;

	@GetMapping
	public List<CategoryDto> getAllCategories() {
		return categoryService.getAllCategories();
	}

	@PostMapping
	public CategoryDto saveCategory(@RequestBody CategoryDto category) {
		return categoryService.saveCategory(category);
	}
}
