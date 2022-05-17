package com.fingo.ecourse.categories.controller.mapper;

import com.fingo.ecourse.categories.controller.model.ControllerModelCategory;
import com.fingo.ecourse.categories.repository.model.RepositoryModelCategoryEntity;
import org.mapstruct.Mapper;

/**
 * @author Barbara Moczulska
 */
@Mapper
public interface ControllerRepositoryModelCategoryMapper {
    RepositoryModelCategoryEntity toCategoryEntity(ControllerModelCategory controllerModelCategory);

    ControllerModelCategory fromCategoryEntity(RepositoryModelCategoryEntity repositoryModelCategoryEntity);

}
