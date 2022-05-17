package com.fingo.ecourse.categories.service.mapper;

import com.fingo.ecourse.categories.repository.model.RepositoryModelCategoryEntity;
import com.fingo.ecourse.categories.service.model.ServiceModelCategory;

/**
 * @author Barbara Moczulska
 */
public class ServiceRepositoryModelCategoryMapperImpl implements ServiceRepositoryModelCategoryMapper {
    @Override
    public RepositoryModelCategoryEntity toCategoryEntity(ServiceModelCategory serviceModelCategory) {
        if (serviceModelCategory == null)
            return null;

        RepositoryModelCategoryEntity repositoryModelCategoryEntity = new RepositoryModelCategoryEntity();
        repositoryModelCategoryEntity.setCategoryName(serviceModelCategory.getCategoryName());

        return repositoryModelCategoryEntity;
    }

    @Override
    public ServiceModelCategory fromCategoryEntity(RepositoryModelCategoryEntity repositoryModelCategoryEntity) {
        if (repositoryModelCategoryEntity == null)
            return null;

        ServiceModelCategory serviceModelCategory = new ServiceModelCategory();
        serviceModelCategory.setCategoryName(repositoryModelCategoryEntity.getCategoryName());

        return serviceModelCategory;
    }
}
