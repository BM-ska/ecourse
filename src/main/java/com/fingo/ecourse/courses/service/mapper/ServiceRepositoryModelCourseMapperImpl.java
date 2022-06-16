package com.fingo.ecourse.courses.service.mapper;

import com.fingo.ecourse.courses.repository.model.CourseEntity;
import com.fingo.ecourse.courses.service.model.ServiceModelCourse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Piotr Stoklosa
 */
public class ServiceRepositoryModelCourseMapperImpl implements ServiceRepositoryModelCourseMapper {

    private static final Logger LOGGER = LogManager.getLogger(ServiceRepositoryModelCourseMapperImpl.class);

    @Override
    public CourseEntity fromServiceToRepositoryModel(ServiceModelCourse serviceModelCourse) {
        LOGGER.info("Mapping from service to repository");

        if (serviceModelCourse == null) {
            LOGGER.error("Service model course is null");
            return null;
        }

        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setCourseName(serviceModelCourse.getCourseName());
        courseEntity.setShortDescription(serviceModelCourse.getShortDescription());
        courseEntity.setLongDescription(serviceModelCourse.getLongDescription());
        courseEntity.setCategoryEntity(serviceModelCourse.getCategoryEntity());

        LOGGER.info("courseEntity: " + courseEntity);
        LOGGER.info("Mapping from service to repository successfully");
        return courseEntity;
    }

    @Override
    public ServiceModelCourse fromRepositoryToServiceModel(CourseEntity courseEntity) {
        LOGGER.info("Mapping from repository to service");

        if (courseEntity == null) {
            LOGGER.error("course entity is null");
            return null;
        }

        ServiceModelCourse serviceModelCourse = new ServiceModelCourse();
        serviceModelCourse.setCourseName(courseEntity.getCourseName());
        serviceModelCourse.setId(courseEntity.getId());
        serviceModelCourse.setShortDescription(courseEntity.getShortDescription());
        serviceModelCourse.setLongDescription(courseEntity.getLongDescription());
        serviceModelCourse.setCategoryEntity(courseEntity.getCategoryEntity());


        LOGGER.info("serviceModelCourse: " + serviceModelCourse);
        LOGGER.info("Mapping from repository to service successfully");

        return serviceModelCourse;
    }
}
