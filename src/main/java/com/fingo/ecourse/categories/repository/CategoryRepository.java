package com.fingo.ecourse.categories.repository;

import com.fingo.ecourse.categories.repository.model.RepositoryModelCategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Piotr Stoklosa
 * @author Kacper Kingsford
 */
@Repository
public interface CategoryRepository extends CrudRepository<RepositoryModelCategoryEntity, Integer> {

}
