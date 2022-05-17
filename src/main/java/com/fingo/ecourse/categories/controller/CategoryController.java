package com.fingo.ecourse.categories.controller;

import com.fingo.ecourse.categories.controller.model.ControllerModelCategory;
import com.fingo.ecourse.categories.service.CategoryService;
import com.fingo.ecourse.categories.service.mapper.ServiceControllerModelCategoryMapper;
import com.fingo.ecourse.categories.service.mapper.ServiceRepositoryModelCategoryMapper;
import com.fingo.ecourse.categories.service.model.ServiceModelCategory;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Piotr Stoklosa
 * @author Kacper Kingsford
 */
@RestController
@RequestMapping("api/v1/category")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    private ServiceControllerModelCategoryMapper mapper = Mappers.getMapper(ServiceControllerModelCategoryMapper.class);

    @GetMapping
    public Iterable<ControllerModelCategory> getAllCategories() {

        Iterable<ServiceModelCategory> serviceModelCategories = categoryService.getAllCategories();


        return serviceModelCategories;//mapper na to Iterable<ControllerModelCategory>
    }

    @PostMapping(consumes = "application/json")
    public ControllerModelCategory saveCategory(@RequestBody ControllerModelCategory category) {

        return categoryService.saveCategory(category); //mapper na to ControllerModelCategory

    }
}
