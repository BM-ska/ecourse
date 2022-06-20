package com.fingo.ecourse.courses.repository.model;

import com.fingo.ecourse.categories.repository.model.CategoryEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Piotr Stoklosa
 */
@Entity
@Table(name = "courses", schema = "public")
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
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
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

    @Basic
    @Column(name = "course_link")
    @Getter
    @Setter
    private String courseLink;
}
