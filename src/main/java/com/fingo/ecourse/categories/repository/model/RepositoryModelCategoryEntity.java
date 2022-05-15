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
import java.util.Objects;

/**
 * @author Piotr Stoklosa
 * @author Kacper Kingsford
 */
@Entity
@Table(name = "Categories", schema = "public")
public class RepositoryModelCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @Getter
    @Setter
    private Integer id;

    @Basic
    @Column(name = "category_name")
    @Getter
    @Setter
    private String categoryName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RepositoryModelCategoryEntity that = (RepositoryModelCategoryEntity) o;
        return id.equals(that.id) && categoryName.equals(that.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryName);
    }
}
