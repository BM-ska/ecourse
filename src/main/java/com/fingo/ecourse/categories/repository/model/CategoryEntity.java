package com.fingo.ecourse.categories.repository.model;

import com.fingo.ecourse.courses.repository.model.CourseEntity;
import com.google.common.base.Objects;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Piotr Stoklosa
 * @author Kacper Kingsford
 */
@Entity
@Table(name = "categories", schema = "public")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter
    @Setter
    private Long id;

    @Basic
    @Column(name = "category_name")
    @Getter
    @Setter
    private String categoryName;

    @Getter
    @Setter
    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, mappedBy = "categoryEntity")
    private Set<CourseEntity> courses;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof CategoryEntity that)) {
            return false;
        }

        return Objects.equal(id, that.id) &&
                Objects.equal(categoryName, that.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, categoryName);
    }
}
