package com.fingo.ecourse.courses.service.model;

import com.fingo.ecourse.categories.repository.model.CategoryEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Piotr Stoklosa
 */
public class ServiceModelCourse {

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String courseName;

    @Getter
    @Setter
    private CategoryEntity categoryEntity;

    @Getter
    @Setter
    private String shortDescription;

    @Getter
    @Setter
    private String longDescription;

    @Getter
    @Setter
    private String courseLink;

}
