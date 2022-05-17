package com.fingo.ecourse.categories.service;

import com.fingo.ecourse.categories.repository.CategoryRepository;
import com.fingo.ecourse.categories.repository.model.RepositoryModelCategoryEntity;
import com.fingo.ecourse.categories.service.mapper.ServiceRepositoryModelCategoryMapper;
import com.fingo.ecourse.categories.service.model.ServiceModelCategory;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

/**
 * @author Piotr Stoklosa
 * @author Kacper Kingsford
 */
@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private ServiceRepositoryModelCategoryMapper mapper = Mappers.getMapper(ServiceRepositoryModelCategoryMapper.class);

    public Iterable<ServiceModelCategory> getAllCategories() {
        Iterable<RepositoryModelCategoryEntity> repositoryModelCategoryEntity = categoryRepository.findAll();
        return  //mapper na to Iterable<ServiceModelCategory>
    }

    public ServiceModelCategory saveCategory(RepositoryModelCategoryEntity category) {
        RepositoryModelCategoryEntity repositoryModelCategoryEntity = categoryRepository.save(category);
        return mapper.fromCategoryEntity(repositoryModelCategoryEntity);
    }
}
