package com.fingo.ecourse.courses.service.mapper;


import com.fingo.ecourse.courses.controller.model.ControllerModelCourse;
import com.fingo.ecourse.courses.service.model.ServiceModelCourse;

/**
 * @author Piotr Stoklosa
 */
public interface ServiceControllerModelCourseMapper {
    ControllerModelCourse fromServiceToControllerModel(ServiceModelCourse serviceModelCourse);

    ServiceModelCourse fromControllerToServiceModel(ControllerModelCourse controllerModelCourse);
}
