package com.fingo.ecourse.courses.repository.model;

import com.fingo.ecourse.categories.repository.model.CategoryEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Piotr Stoklosa
 */
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter
    @Setter
    private Long id;

    @Basic
    @Column(name = "course_name")
    @Getter
    @Setter
    private String courseName;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_category", nullable = false)
    private CategoryEntity categoryEntity;

    @Basic
    @Column(name = "short_description")
    @Getter
    @Setter
    private String shortDescription;

    @Basic
    @Column(name = "long_description")
    @Getter
    @Setter
    private String longDescription;
}
