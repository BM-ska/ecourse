package com.fingo.ecourse.categories.service.mapper;

import com.fingo.ecourse.categories.repository.model.RepositoryModelCategoryEntity;
import com.fingo.ecourse.categories.service.model.ServiceModelCategory;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class ServiceRepositoryModelCategoryMapperImplTest {
    private final ServiceRepositoryModelCategoryMapper mapper = Mappers.getMapper(ServiceRepositoryModelCategoryMapper.class);

    @Test
    public void mapperFromServiceToRepository(){

        ServiceModelCategory serviceModelCategory = new ServiceModelCategory();
        serviceModelCategory.setCategoryName("category name");

        RepositoryModelCategoryEntity repositoryModelCategoryEntity = mapper.fromServiceToRepositoryModel(serviceModelCategory);

        assertEquals(serviceModelCategory.getCategoryName(), repositoryModelCategoryEntity.getCategoryName());
    }

    @Test
    public void mapperFromRepositoryToService(){

        RepositoryModelCategoryEntity repositoryModelCategoryEntity = new RepositoryModelCategoryEntity();
        repositoryModelCategoryEntity.setCategoryName("category name");

        ServiceModelCategory serviceModelCategory = mapper.fromRepositoryToServiceModel(repositoryModelCategoryEntity);

        assertEquals(serviceModelCategory.getCategoryName(), repositoryModelCategoryEntity.getCategoryName());
    }
}
