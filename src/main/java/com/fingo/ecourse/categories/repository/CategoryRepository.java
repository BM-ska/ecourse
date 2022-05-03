package com.fingo.ecourse.categories.repository;

import com.fingo.ecourse.uuid.generator.UuidGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public interface CategoryRepository {
	List<CategoryDto> getAll();
	CategoryDto save(CategoryDto category);
}

@Repository
@AllArgsConstructor
class InMemoryCategoryRepository implements CategoryRepository{
	private final List<CategoryDto> store = new ArrayList<>();
	private final UuidGenerator uuidGenerator;

	@Override
	public List<CategoryDto> getAll() {
		return store;
	}

	@Override
	public CategoryDto save(CategoryDto category) {
		category.setUuid(uuidGenerator.generateId());
		store.add(category);
		return category;
	}
}
