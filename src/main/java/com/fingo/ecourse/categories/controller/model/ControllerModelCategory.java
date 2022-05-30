package com.fingo.ecourse.categories.controller.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Barbara Moczulska
 */
public class ControllerModelCategory {

    @Getter
    @Setter
    private String categoryName;
    @Getter
    @Setter
    private Long id;

}
