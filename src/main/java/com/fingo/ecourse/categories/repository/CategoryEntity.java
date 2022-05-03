package com.fingo.ecourse.categories.repository;

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
public class CategoryEntity {

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
    private String category_name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryEntity that = (CategoryEntity) o;
        return id.equals(that.id) && category_name.equals(that.category_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category_name);
    }
}
