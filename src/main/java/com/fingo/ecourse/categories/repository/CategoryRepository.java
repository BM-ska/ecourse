package com.fingo.ecourse.categories.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Piotr Stoklosa
 * @author Kacper Kingsford
 */
@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity, Integer> {

}