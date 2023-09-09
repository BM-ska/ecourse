package com.fingo.ecourse.courses.repository;

import com.fingo.ecourse.courses.repository.model.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Piotr Stoklosa
 */
@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {

    Optional<CourseEntity> findByCourseNameIgnoreCase(String courseName);

    List<CourseEntity> findByCategoryEntityId(Long categoryEntityId);
}
