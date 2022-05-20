package com.fingo.ecourse.categories.service.mapper;

import com.fingo.ecourse.categories.controller.model.ControllerModelCategory;
import com.fingo.ecourse.categories.service.model.ServiceModelCategory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Barbara Moczulska
 */
public class ServiceControllerModelCategoryMapperImpl implements ServiceControllerModelCategoryMapper {

    private static final Logger LOGGER = LogManager.getLogger(ServiceControllerModelCategoryMapperImpl.class);

    @Override
    public ControllerModelCategory fromServiceToControllerModel(ServiceModelCategory serviceModelCategory) {
        LOGGER.info("Mapping from service to controller");

        if (serviceModelCategory == null) {
            LOGGER.error("service model category is null");
            return null;
        }

        ControllerModelCategory controllerModelCategory = new ControllerModelCategory();
        controllerModelCategory.setCategoryName(serviceModelCategory.getCategoryName());

        LOGGER.info("controllerModelCategory: " + controllerModelCategory);
        LOGGER.info("Mapping from service to controller successfully");
        return controllerModelCategory;
    }

    @Override
    public ServiceModelCategory fromControllerToServiceModel(ControllerModelCategory controllerModelCategory) {
        LOGGER.info("Mapping from controller to service");

        if (controllerModelCategory == null) {
            LOGGER.error("controller model category is null");
            return null;
        }

        ServiceModelCategory serviceModelCategory = new ServiceModelCategory();
        serviceModelCategory.setCategoryName(controllerModelCategory.getCategoryName());

        LOGGER.info("serviceModelCategory: " + serviceModelCategory);
        LOGGER.info("Mapping from controller to service successfully");

        return serviceModelCategory;
    }
}
