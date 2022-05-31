package com.fingo.ecourse.courses.service.mapper;

import com.fingo.ecourse.courses.repository.model.CourseEntity;
import com.fingo.ecourse.courses.service.model.ServiceModelCourse;

/**
 * @author Piotr Stoklosa
 */
public interface ServiceRepositoryModelCourseMapper {
    CourseEntity fromServiceToRepositoryModel(ServiceModelCourse serviceModelCourse);

    ServiceModelCourse fromRepositoryToServiceModel(CourseEntity courseEntity);
}
