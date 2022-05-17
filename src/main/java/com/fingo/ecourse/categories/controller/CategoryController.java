package com.fingo.ecourse.categories.controller;

import com.fingo.ecourse.categories.controller.model.ControllerModelCategory;
import com.fingo.ecourse.categories.repository.model.RepositoryModelCategoryEntity;
import com.fingo.ecourse.categories.service.CategoryService;
import com.fingo.ecourse.categories.service.mapper.ServiceControllerModelCategoryMapper;
import com.fingo.ecourse.categories.service.model.ServiceModelCategory;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Piotr Stoklosa
 * @author Kacper Kingsford
 * @author Barbara Moczulska
 */
@RestController
@RequestMapping("api/v1/category")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    private final ServiceControllerModelCategoryMapper mapper = Mappers.getMapper(ServiceControllerModelCategoryMapper.class);

    @GetMapping
    public Iterable<ControllerModelCategory> getAllCategories() {

        Iterable<ServiceModelCategory> serviceModelCategories = categoryService.getAllCategories();

        List<ControllerModelCategory> tmp = new ArrayList<>();
        serviceModelCategories.forEach(x -> tmp.add(mapper.toCategoryEntity(x)));

        return tmp;
    }

    @PostMapping(consumes = "application/json")
    public ControllerModelCategory saveCategory(@RequestBody RepositoryModelCategoryEntity category) {

        return mapper.toCategoryEntity(categoryService.saveCategory(category));
    }
}
