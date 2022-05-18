package com.fingo.ecourse.categories.service.mapper;

import com.fingo.ecourse.categories.repository.model.RepositoryModelCategoryEntity;
import com.fingo.ecourse.categories.service.model.ServiceModelCategory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Barbara Moczulska
 */
public class ServiceRepositoryModelCategoryMapperImpl implements ServiceRepositoryModelCategoryMapper {
    private static final Logger LOGGER = LogManager.getLogger(ServiceRepositoryModelCategoryMapperImpl.class);

    @Override
    public RepositoryModelCategoryEntity toCategoryEntity(ServiceModelCategory serviceModelCategory) {
        LOGGER.info("Mapping from service to repository");

        if (serviceModelCategory == null) {
            LOGGER.error("service model category is null");
            return null;
        }

        RepositoryModelCategoryEntity repositoryModelCategoryEntity = new RepositoryModelCategoryEntity();
        repositoryModelCategoryEntity.setCategoryName(serviceModelCategory.getCategoryName());

        LOGGER.info("repositoryModelCategoryEntity: " + repositoryModelCategoryEntity);
        LOGGER.info("Mapping from service to repository successfully");

        return repositoryModelCategoryEntity;
    }

    @Override
    public ServiceModelCategory fromCategoryEntity(RepositoryModelCategoryEntity repositoryModelCategoryEntity) {
        LOGGER.info("Mapping from repository to service");

        if (repositoryModelCategoryEntity == null) {
            LOGGER.error("repository model category is null");
            return null;
        }

        ServiceModelCategory serviceModelCategory = new ServiceModelCategory();
        serviceModelCategory.setCategoryName(repositoryModelCategoryEntity.getCategoryName());

        LOGGER.info("serviceModelCategory: " + serviceModelCategory);
        LOGGER.info("Mapping from repository to service successfully");

        return serviceModelCategory;
    }
}
