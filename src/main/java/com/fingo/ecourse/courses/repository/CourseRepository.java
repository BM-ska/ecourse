package com.fingo.ecourse.courses.repository;

import com.fingo.ecourse.categories.repository.model.CategoryEntity;
import com.fingo.ecourse.courses.repository.model.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Piotr Stoklosa
 */
@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {

    Optional<CourseEntity> findByCourseNameContainsIgnoreCase(String courseName);

    @Query("SELECT c FROM CourseEntity c WHERE c.categoryEntity =:categoryEntity")
    List<CourseEntity> retrieveByCategoryName(@Param("categoryEntity") CategoryEntity categoryEntity);
}
