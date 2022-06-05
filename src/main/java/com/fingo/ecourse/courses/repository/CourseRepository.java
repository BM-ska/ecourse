package com.fingo.ecourse.courses.repository;

import com.fingo.ecourse.courses.repository.model.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Piotr Stoklosa
 */
@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {
    Optional<CourseEntity> findByCourseNameContainsIgnoreCase(String courseName);
}
