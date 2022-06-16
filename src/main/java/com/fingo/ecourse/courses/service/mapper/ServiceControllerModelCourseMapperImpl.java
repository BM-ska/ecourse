package com.fingo.ecourse.courses.service.mapper;

import com.fingo.ecourse.courses.controller.exception.model.NotFoundException;
import com.fingo.ecourse.categories.repository.CategoryRepository;
import com.fingo.ecourse.courses.controller.model.ControllerModelCourse;
import com.fingo.ecourse.courses.controller.model.ControllerModelCourseWithoutId;
import com.fingo.ecourse.courses.service.model.ServiceModelCourse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Piotr Stoklosa
 */
@Component
public class ServiceControllerModelCourseMapperImpl implements ServiceControllerModelCourseMapper {

    private static final Logger LOGGER = LogManager.getLogger(ServiceControllerModelCourseMapperImpl.class);

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public ControllerModelCourse fromServiceToControllerModel(ServiceModelCourse serviceModelCourse) {
        LOGGER.info("Mapping from service to controller");

        if (serviceModelCourse == null) {
            LOGGER.error("Service model course is null");
            return null;
        }

        ControllerModelCourse controllerModelCourse = new ControllerModelCourse();
        controllerModelCourse.setCourseName(serviceModelCourse.getCourseName());
        controllerModelCourse.setId(serviceModelCourse.getId());
        controllerModelCourse.setShortDescription(serviceModelCourse.getShortDescription());
        controllerModelCourse.setLongDescription(serviceModelCourse.getLongDescription());
        controllerModelCourse.setCategoryName(serviceModelCourse.getCategoryEntity().getCategoryName());

        LOGGER.info("controllerModelCourse: " + controllerModelCourse);
        LOGGER.info("Mapping from service to controller successfully");
        return controllerModelCourse;
    }

    @Override
    public ServiceModelCourse fromControllerToServiceModel(ControllerModelCourse controllerModelCourse) throws NotFoundException {
        LOGGER.info("Mapping from controller to service");

        if (controllerModelCourse == null) {
            LOGGER.error("controller model course is null");
            return null;
        }

        ServiceModelCourse serviceModelCourse = new ServiceModelCourse();
        serviceModelCourse.setCourseName(controllerModelCourse.getCourseName());
        serviceModelCourse.setId(controllerModelCourse.getId());
        serviceModelCourse.setShortDescription(controllerModelCourse.getShortDescription());
        serviceModelCourse.setLongDescription(controllerModelCourse.getLongDescription());
        serviceModelCourse.setCategoryEntity(categoryRepository.findByCategoryNameIgnoreCase(
                        controllerModelCourse.getCategoryName())
                .orElseThrow(() -> new NotFoundException(
                        "Category " + controllerModelCourse.getCategoryName() + " not found!")));

        LOGGER.info("serviceModelCourse: " + serviceModelCourse);
        LOGGER.info("Mapping from controller to service successfully");

        return serviceModelCourse;
    }

    @Override
    public ServiceModelCourse fromControllerToServiceModel(ControllerModelCourseWithoutId controllerModelCourse) throws NotFoundException {
        LOGGER.info("Mapping from controller to service");

        if (controllerModelCourse == null) {
            LOGGER.error("controller model course is null");
            return null;
        }

        ServiceModelCourse serviceModelCourse = new ServiceModelCourse();
        serviceModelCourse.setCourseName(controllerModelCourse.getCourseName());
        serviceModelCourse.setShortDescription(controllerModelCourse.getShortDescription());
        serviceModelCourse.setLongDescription(controllerModelCourse.getLongDescription());
        serviceModelCourse.setCategoryEntity(categoryRepository.findByCategoryNameIgnoreCase(
                        controllerModelCourse.getCategoryName())
                .orElseThrow(() -> new NotFoundException(
                        "Category " + controllerModelCourse.getCategoryName() + " not found!")));

        LOGGER.info("serviceModelCourse: " + serviceModelCourse);
        LOGGER.info("Mapping from controller to service successfully");

        return serviceModelCourse;
    }
}
