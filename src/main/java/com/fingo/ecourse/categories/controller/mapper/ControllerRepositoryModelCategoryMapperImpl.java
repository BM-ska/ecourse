package com.fingo.ecourse.categories.controller.mapper;

import com.fingo.ecourse.categories.controller.model.ControllerModelCategory;
import com.fingo.ecourse.categories.repository.model.RepositoryModelCategoryEntity;

/**
 * @author Barbara Moczulska
 */
public class ControllerRepositoryModelCategoryMapperImpl implements ControllerRepositoryModelCategoryMapper {
    @Override
    public RepositoryModelCategoryEntity toCategoryEntity(ControllerModelCategory controllerModelCategory) {
        if (controllerModelCategory == null)
            return null;

        RepositoryModelCategoryEntity repositoryModelCategoryEntity = new RepositoryModelCategoryEntity();
        repositoryModelCategoryEntity.setCategoryName(controllerModelCategory.getCategoryName());

        return repositoryModelCategoryEntity;
    }

    @Override
    public ControllerModelCategory fromCategoryEntity(RepositoryModelCategoryEntity repositoryModelCategoryEntity) {
        if (repositoryModelCategoryEntity == null)
            return null;

        ControllerModelCategory controllerModelCategory = new ControllerModelCategory();
        controllerModelCategory.setCategoryName(repositoryModelCategoryEntity.getCategoryName());

        return controllerModelCategory;
    }
}
