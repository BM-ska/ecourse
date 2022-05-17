package com.fingo.ecourse.categories.service.mapper;

import com.fingo.ecourse.categories.controller.model.ControllerModelCategory;
import com.fingo.ecourse.categories.service.model.ServiceModelCategory;

/**
 * @author Barbara Moczulska
 */
public class ServiceControllerModelCategoryMapperImpl implements ServiceControllerModelCategoryMapper {
    @Override
    public ControllerModelCategory toCategoryEntity(ServiceModelCategory serviceModelCategory) {
        if (serviceModelCategory == null)
            return null;

        ControllerModelCategory controllerModelCategory = new ControllerModelCategory();
        controllerModelCategory.setCategoryName(serviceModelCategory.getCategoryName());

        return controllerModelCategory;
    }

    @Override
    public ServiceModelCategory fromCategoryEntity(ControllerModelCategory controllerModelCategory) {
        if (controllerModelCategory == null)
            return null;

        ServiceModelCategory serviceModelCategory = new ServiceModelCategory();
        serviceModelCategory.setCategoryName(controllerModelCategory.getCategoryName());

        return serviceModelCategory;
    }
}
