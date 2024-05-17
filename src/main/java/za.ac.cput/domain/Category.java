/**
 * E-Commerce Web Application for selling clothes
 * Category.java
 * This POJO class for the Category entity. Domain class using Builder Pattern
 * Author: Mthandeni Mbobo - 218223579
 * Date: 22 March 2024
 */

package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Category")
public class Category {
    //Attributes
    @Id
    private String categoryID;
    private String categoryName;

    //Constructor
    public Category(){
        //
    }

    private Category(Builder builder){
        this.categoryID = builder.categoryID;
        this.categoryName = builder.categoryName;
    }

    //Getters
    public String getCategoryID() {
        return categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(categoryID, category.categoryID) && Objects.equals(categoryName, category.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryID, categoryName);
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryID='" + categoryID + '\'' +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }

    //Builder Pattern
    public static class Builder{
        private String categoryID;
        private String categoryName;

        public Builder setCategoryID(String categoryID){
            this.categoryID = categoryID;
            return this;
        }

        public Builder setCategoryName(String categoryName){
            this.categoryName = categoryName;
            return this;
        }

        public Builder copy(Category category){
            this.categoryID = category.categoryID;
            this.categoryName = category.categoryName;
            return this;
        }

        public Category build(){
            return new Category(this);
        }
    }
}
