package com.fingo.ecourse.categories.service.mapper;

import com.fingo.ecourse.categories.repository.model.CategoryEntity;
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

        CategoryEntity categoryEntity = mapper.fromServiceToRepositoryModel(serviceModelCategory);

        assertEquals(serviceModelCategory.getCategoryName(), categoryEntity.getCategoryName());
    }

    @Test
    public void mapperFromRepositoryToService(){

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryName("category name");

        ServiceModelCategory serviceModelCategory = mapper.fromRepositoryToServiceModel(categoryEntity);

        assertEquals(serviceModelCategory.getCategoryName(), categoryEntity.getCategoryName());
    }
}
