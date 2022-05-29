package com.fingo.ecourse.categories.controller;

import com.fingo.ecourse.categories.controller.model.ControllerModelCategory;
import com.fingo.ecourse.categories.controller.model.ControllerModelCategoryWithoutId;
import com.fingo.ecourse.categories.service.CategoryService;
import com.fingo.ecourse.categories.service.mapper.ServiceControllerModelCategoryMapper;
import com.fingo.ecourse.categories.service.model.ServiceModelCategory;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Piotr Stoklosa
 * @author Kacper Kingsford
 * @author Barbara Moczulska
 */
@RestController
@RequestMapping("api/v1/categories")
@AllArgsConstructor
public class CategoryController {
	private static final Logger LOGGER = LogManager.getLogger(CategoryController.class);

	private final CategoryService categoryService;
	private final ServiceControllerModelCategoryMapper mapper = Mappers.getMapper(ServiceControllerModelCategoryMapper.class);

	@GetMapping
	public Iterable<ControllerModelCategory> getAllCategories() {
		LOGGER.info("Get all categories");

		Iterable<ServiceModelCategory> serviceModelCategories = categoryService.getAllCategories();

		List<ControllerModelCategory> tmp = new ArrayList<>();
		serviceModelCategories.forEach(x -> tmp.add(mapper.fromServiceToControllerModel(x)));

		LOGGER.info("Categories: " + tmp);
		LOGGER.info("Get all categories successfully");

		return tmp;
	}

	@GetMapping("/{categoryName}")
	public ControllerModelCategory getCategoryByName(@PathVariable String categoryName) throws Exception {
		LOGGER.info("Get {} category", categoryName);
		ServiceModelCategory categoryByName = categoryService.getCategoryByName(categoryName);
		return mapper.fromServiceToControllerModel(categoryByName);
	}

	@PostMapping(consumes = "application/json")
	public ResponseEntity<Long> saveCategory(@RequestBody ControllerModelCategoryWithoutId category) {
		LOGGER.info("Save category to controller");
		ServiceModelCategory controllerModelCategory = mapper.fromControllerToServiceModel(category);
		long id = categoryService.saveCategory(controllerModelCategory);

		LOGGER.info("Saved category {} to controller successfully", controllerModelCategory);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(id);
	}
}
