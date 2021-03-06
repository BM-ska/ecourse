package com.fingo.ecourse.courses.service;

import com.fingo.ecourse.categories.repository.CategoryRepository;
import com.fingo.ecourse.categories.repository.model.CategoryEntity;
import com.fingo.ecourse.courses.controller.exception.model.CourseDuplicateException;
import com.fingo.ecourse.courses.controller.exception.model.NotFoundException;
import com.fingo.ecourse.courses.repository.CourseRepository;
import com.fingo.ecourse.courses.repository.model.CourseEntity;
import com.fingo.ecourse.courses.service.mapper.ServiceRepositoryModelCourseMapper;
import com.fingo.ecourse.courses.service.model.ServiceModelCourse;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Piotr Stoklosa
 */
@Service
@AllArgsConstructor
public class CourseService {
    private static final Logger LOGGER = LogManager.getLogger(CourseService.class);

    private final CourseRepository courseRepository;
    private final CategoryRepository categoryRepository;
    private final ServiceRepositoryModelCourseMapper mapper = Mappers.getMapper(ServiceRepositoryModelCourseMapper.class);

    public Iterable<ServiceModelCourse> getAllCourses() {
        LOGGER.info("Get all courses");
        Iterable<CourseEntity> repositoryModelCourseEntityIterable = courseRepository.findAll();

        List<ServiceModelCourse> tmp = new ArrayList<>();
        repositoryModelCourseEntityIterable.forEach(x -> tmp.add(mapper.fromRepositoryToServiceModel(x)));

        LOGGER.info("Courses: " + tmp);
        LOGGER.info("Get all courses by category name successfully");

        return tmp;
    }

    public Iterable<ServiceModelCourse> getAllCoursesByCategoryName(String categoryName) throws NotFoundException {
        LOGGER.info("Get all courses by category name: " + categoryName);

        CategoryEntity categoryEntity = categoryRepository.findAll()
                .stream()
                .filter(category -> category.getCategoryName().equals(categoryName))
                .findFirst().orElseThrow(() -> new NotFoundException("Category " + categoryName + " does not exist"));
        List<CourseEntity> repositoryModelCourseEntityIterable = courseRepository.findByCategoryEntityId(categoryEntity.getId());

        List<ServiceModelCourse> tmp = new ArrayList<>();
        repositoryModelCourseEntityIterable.forEach(x -> tmp.add(mapper.fromRepositoryToServiceModel(x)));

        LOGGER.info("Courses: " + tmp);
        LOGGER.info("Get all courses by category name successfully");

        return tmp;
    }

    public long saveCourse(ServiceModelCourse course) {
        LOGGER.info("Save course to repository");
        if (courseRepository.findByCourseNameIgnoreCase(course.getCourseName()).isPresent()) {
            throw new CourseDuplicateException("Course " + course.getCourseName() + " already exists!");
        }
        CourseEntity courseEntity = mapper.fromServiceToRepositoryModel(course);
        LOGGER.info("Saved course {} successfully", courseEntity);
        return courseRepository.saveAndFlush(courseEntity).getId();
    }

    public ServiceModelCourse getCourseByName(String courseName) throws NotFoundException {
        return courseRepository.findByCourseNameIgnoreCase(courseName)
                .map(mapper::fromRepositoryToServiceModel)
                .orElseThrow(() -> new NotFoundException("Course " + courseName + " not found!"));
    }
}
