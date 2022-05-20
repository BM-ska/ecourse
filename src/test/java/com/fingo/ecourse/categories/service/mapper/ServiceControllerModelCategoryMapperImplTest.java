package com.fingo.ecourse.categories.service.mapper;

import com.fingo.ecourse.categories.controller.model.ControllerModelCategory;
import com.fingo.ecourse.categories.service.model.ServiceModelCategory;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class ServiceControllerModelCategoryMapperImplTest {

    private final ServiceControllerModelCategoryMapper mapper = Mappers.getMapper(ServiceControllerModelCategoryMapper.class);

    @Test
    public void mapperFromServiceToController(){

        ServiceModelCategory serviceModelCategory = new ServiceModelCategory();
        serviceModelCategory.setCategoryName("category name");

        ControllerModelCategory controllerModelCategory = mapper.fromServiceToControllerModel(serviceModelCategory);

        assertEquals(serviceModelCategory.getCategoryName(), controllerModelCategory.getCategoryName());
    }

    @Test
    public void mapperFromControllerToService(){

        ControllerModelCategory controllerModelCategory = new ControllerModelCategory();
        controllerModelCategory.setCategoryName("category name");

        ServiceModelCategory serviceModelCategory = mapper.fromControllerToServiceModel(controllerModelCategory);

        assertEquals(serviceModelCategory.getCategoryName(), controllerModelCategory.getCategoryName());
    }
}
