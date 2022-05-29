package com.fingo.ecourse.categories.repository;

import com.fingo.ecourse.categories.repository.model.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Piotr Stoklosa
 * @author Kacper Kingsford
 * @author Barbara Moczulska
 */
@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {

}
