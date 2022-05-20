package com.fingo.ecourse.categories.service.mapper;

import com.fingo.ecourse.categories.repository.model.RepositoryModelCategoryEntity;
import com.fingo.ecourse.categories.service.model.ServiceModelCategory;
import org.mapstruct.Mapper;

/**
 * @author Barbara Moczulska
 */
@Mapper
public interface ServiceRepositoryModelCategoryMapper {
    RepositoryModelCategoryEntity fromServiceToRepositoryModel(ServiceModelCategory serviceModelCategory);

    ServiceModelCategory fromRepositoryToServiceModel(RepositoryModelCategoryEntity repositoryModelCategoryEntity);

}
