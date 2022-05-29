package com.fingo.ecourse.categories.service.mapper;

import com.fingo.ecourse.categories.repository.model.CategoryEntity;
import com.fingo.ecourse.categories.service.model.ServiceModelCategory;
import org.mapstruct.Mapper;

/**
 * @author Barbara Moczulska
 */
@Mapper
public interface ServiceRepositoryModelCategoryMapper {
    CategoryEntity fromServiceToRepositoryModel(ServiceModelCategory serviceModelCategory);

    ServiceModelCategory fromRepositoryToServiceModel(CategoryEntity categoryEntity);

}
