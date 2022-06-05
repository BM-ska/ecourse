package com.fingo.ecourse.courses.controller.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;

/**
 * @author Piotr Stoklosa
 */
@Controller
public class ControllerModelCourse {

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String courseName;

    @Getter
    @Setter
    private String categoryName;

    @Getter
    @Setter
    private String shortDescription;

    @Getter
    @Setter
    private String longDescription;

}
