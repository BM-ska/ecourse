package com.fingo.ecourse.categories.service.mapper;

import com.fingo.ecourse.categories.repository.model.CategoryEntity;
import com.fingo.ecourse.categories.service.model.ServiceModelCategory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Barbara Moczulska
 */
public class ServiceRepositoryModelCategoryMapperImpl implements ServiceRepositoryModelCategoryMapper {
    private static final Logger LOGGER = LogManager.getLogger(ServiceRepositoryModelCategoryMapperImpl.class);

    @Override
    public CategoryEntity fromServiceToRepositoryModel(ServiceModelCategory serviceModelCategory) {
        LOGGER.info("Mapping from service to repository");

        if (serviceModelCategory == null) {
            LOGGER.error("service model category is null");
            return null;
        }

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryName(serviceModelCategory.getCategoryName());

        LOGGER.info("repositoryModelCategoryEntity: " + categoryEntity);
        LOGGER.info("Mapping from service to repository successfully");

        return categoryEntity;
    }

    @Override
    public ServiceModelCategory fromRepositoryToServiceModel(CategoryEntity categoryEntity) {
        LOGGER.info("Mapping from repository to service");

        if (categoryEntity == null) {
            LOGGER.error("repository model category is null");
            return null;
        }

        ServiceModelCategory serviceModelCategory = new ServiceModelCategory();
        serviceModelCategory.setCategoryName(categoryEntity.getCategoryName());
        serviceModelCategory.setId(categoryEntity.getId());

        LOGGER.info("serviceModelCategory: " + serviceModelCategory);
        LOGGER.info("Mapping from repository to service successfully");

        return serviceModelCategory;
    }
}
