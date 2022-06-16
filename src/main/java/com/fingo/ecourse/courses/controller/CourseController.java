package com.fingo.ecourse.courses.controller;

import com.fingo.ecourse.courses.controller.exception.model.NotFoundException;
import com.fingo.ecourse.courses.controller.model.ControllerModelCourse;
import com.fingo.ecourse.courses.controller.model.ControllerModelCourseWithoutId;
import com.fingo.ecourse.courses.service.CourseService;
import com.fingo.ecourse.courses.service.mapper.ServiceControllerModelCourseMapper;
import com.fingo.ecourse.courses.service.model.ServiceModelCourse;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Piotr Stoklosa
 */
@RestController
@RequestMapping("api/v1/courses")
@AllArgsConstructor
public class CourseController {
    private static final Logger LOGGER = LogManager.getLogger(CourseController.class);

    private final CourseService courseService;
    @Autowired
    private final ServiceControllerModelCourseMapper mapper = Mappers.getMapper(ServiceControllerModelCourseMapper.class);

    @GetMapping
    public Iterable<ControllerModelCourse> getAllCourses() {
        LOGGER.info("Get all courses");

        Iterable<ServiceModelCourse> serviceModelCourses = courseService.getAllCourses();

        List<ControllerModelCourse> tmp = new ArrayList<>();
        serviceModelCourses.forEach(x -> tmp.add(mapper.fromServiceToControllerModel(x)));

        LOGGER.info("Courses: " + tmp);
        LOGGER.info("Get all courses successfully");

        return tmp;
    }

/*    @GetMapping("/{categoryName}")
    public ControllerModelCategory getAllCoursesByCategoryName(@PathVariable String categoryName) throws Exception {
        LOGGER.info("Get all courses from {} category", categoryName);

        Iterable<ServiceModelCourse> serviceModelCourses = courseService.;

        List<ControllerModelCourse> tmp = new ArrayList<>();
        serviceModelCourses.forEach(x -> tmp.add(mapper.fromServiceToControllerModel(x)));

        ServiceModelCategory categoryByName = categoryService.getCategoryByName(categoryName);
        return mapper.fromServiceToControllerModel(categoryByName);
    }*/

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Long> saveCourse(@RequestBody ControllerModelCourseWithoutId course) throws NotFoundException {
        LOGGER.info("Save course to controller");
        ServiceModelCourse controllerModelCourse = mapper.fromControllerToServiceModel(course);
        long id = courseService.saveCourse(controllerModelCourse);

        LOGGER.info("Saved course {} to controller successfully", controllerModelCourse);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(id);
    }

}
