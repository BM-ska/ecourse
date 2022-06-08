package com.fingo.ecourse.courses.service.mapper;


import com.fingo.ecourse.courses.controller.exception.model.NotFoundException;
import com.fingo.ecourse.courses.controller.model.ControllerModelCourse;
import com.fingo.ecourse.courses.service.model.ServiceModelCourse;
import org.mapstruct.Mapper;

/**
 * @author Piotr Stoklosa
 */
@Mapper(componentModel = "spring")
public interface ServiceControllerModelCourseMapper {
    ControllerModelCourse fromServiceToControllerModel(ServiceModelCourse serviceModelCourse);

    ServiceModelCourse fromControllerToServiceModel(ControllerModelCourse controllerModelCourse) throws NotFoundException;
}
