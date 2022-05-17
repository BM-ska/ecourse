package com.fingo.ecourse.categories.service;

import com.fingo.ecourse.categories.repository.CategoryRepository;
import com.fingo.ecourse.categories.repository.model.RepositoryModelCategoryEntity;
import com.fingo.ecourse.categories.service.mapper.ServiceRepositoryModelCategoryMapper;
import com.fingo.ecourse.categories.service.model.ServiceModelCategory;
import lombok.AllArgsConstructor;
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

    private final CategoryRepository categoryRepository;
    private final ServiceRepositoryModelCategoryMapper mapper = Mappers.getMapper(ServiceRepositoryModelCategoryMapper.class);

    public Iterable<ServiceModelCategory> getAllCategories() {
        Iterable<RepositoryModelCategoryEntity> repositoryModelCategoryEntityIterable = categoryRepository.findAll();

        List<ServiceModelCategory> tmp = new ArrayList<>();
        repositoryModelCategoryEntityIterable.forEach(x -> tmp.add(mapper.fromCategoryEntity(x)));

        return tmp;
    }

    public ServiceModelCategory saveCategory(RepositoryModelCategoryEntity category) {
        RepositoryModelCategoryEntity repositoryModelCategoryEntity = categoryRepository.save(category);
        return mapper.fromCategoryEntity(repositoryModelCategoryEntity);
    }
}
