package com.fingo.ecourse.categories.service.mapper;

import com.fingo.ecourse.categories.controller.model.ControllerModelCategory;
import com.fingo.ecourse.categories.service.model.ServiceModelCategory;
import org.mapstruct.Mapper;

/**
 * @author Barbara Moczulska
 */
@Mapper
public interface ServiceControllerModelCategoryMapper {
    ControllerModelCategory toCategoryEntity(ServiceModelCategory serviceModelCategory);

    ServiceModelCategory fromCategoryEntity(ControllerModelCategory controllerModelCategory);

}
