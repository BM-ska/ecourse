package com.fingo.ecourse.categories.service;

import com.fingo.ecourse.categories.controller.exception.model.CategoryDuplicateException;
import com.fingo.ecourse.categories.controller.exception.model.NotFoundException;
import com.fingo.ecourse.categories.repository.CategoryRepository;
import com.fingo.ecourse.categories.repository.model.CategoryEntity;
import com.fingo.ecourse.categories.service.mapper.ServiceRepositoryModelCategoryMapper;
import com.fingo.ecourse.categories.service.model.ServiceModelCategory;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Piotr Stoklosa
 * @author Kacper Kingsford
 * @author Barbara Moczulska
 */
@Service
@AllArgsConstructor
public class CategoryService {
	private static final Logger LOGGER = LogManager.getLogger(CategoryService.class);

	private final CategoryRepository categoryRepository;
	private final ServiceRepositoryModelCategoryMapper mapper = Mappers.getMapper(ServiceRepositoryModelCategoryMapper.class);

	public Iterable<ServiceModelCategory> getAllCategories() {
		LOGGER.info("Get all categories");
		Iterable<CategoryEntity> repositoryModelCategoryEntityIterable = categoryRepository.findAll();

		List<ServiceModelCategory> tmp = new ArrayList<>();
		repositoryModelCategoryEntityIterable.forEach(x -> tmp.add(mapper.fromRepositoryToServiceModel(x)));

		LOGGER.info("Categories: " + tmp);
		LOGGER.info("Get all categories successfully");

		return tmp;
	}

	public long saveCategory(ServiceModelCategory category) {
		LOGGER.info("Save category to repository");
		if (categoryRepository.findByCategoryNameIgnoreCase(category.getCategoryName()).isPresent()) {
			throw new CategoryDuplicateException("Category " + category.getCategoryName() + " already exists!");
		}
		CategoryEntity categoryEntity = mapper.fromServiceToRepositoryModel(category);
		LOGGER.info("Saved category {} successfully", categoryEntity);
		return categoryRepository.saveAndFlush(categoryEntity).getId();
	}

	public ServiceModelCategory getCategoryByName(String categoryName) throws NotFoundException {
		return categoryRepository.findByCategoryNameIgnoreCase(categoryName)
				.map(mapper::fromRepositoryToServiceModel)
				.orElseThrow(() -> new NotFoundException("Category " + categoryName + " not found!"));
	}
}
