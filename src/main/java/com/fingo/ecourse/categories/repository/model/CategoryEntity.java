package com.fingo.ecourse.categories.repository.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.google.common.base.Objects;

/**
 * @author Piotr Stoklosa
 * @author Kacper Kingsford
 */
@Entity
@Table(name = "Categories", schema = "public")
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
