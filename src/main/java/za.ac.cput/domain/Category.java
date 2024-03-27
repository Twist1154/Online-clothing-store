/**
 * E-Commerce Web Application for selling clothes
 * Category.java
 * This POJO class for the Category entity. Domain class using Builder Pattern
 * Author: Mthandeni Mbobo - 218223579
 * Date: 22 March 2024
 */

package za.ac.cput.domain;

import java.util.List;
import java.util.Objects;

public class Category {
    //Attributes
    private String categoryID;
    private String categoryName;
    private String categoryDescription;
    //private List<Product> product;

    //Constructor
    public Category(){
        //
    }

    private Category(Builder builder){
        this.categoryID = builder.categoryID;
        this.categoryName = builder.categoryName;
        this.categoryDescription = builder.categoryDescription;
        //this.product = builder.product;
    }

    //Getters
    public String getCategoryID() {
        return categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    /*public List<Product> getproduct() {
        return product;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(categoryID, category.categoryID) && Objects.equals(categoryName, category.categoryName) && Objects.equals(categoryDescription, category.categoryDescription);
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryID='" + categoryID + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", categoryDescription='" + categoryDescription + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryID, categoryName, categoryDescription);
    }

    //Builder Pattern
    public static class Builder{
        private String categoryID;
        private String categoryName;
        private String categoryDescription;
        //private List<Product> product;

        public Builder setCategoryID(String categoryID){
            this.categoryID = categoryID;
            return this;
        }

        public Builder setCategoryName(String categoryName){
            this.categoryName = categoryName;
            return this;
        }

        public Builder setCategoryDescription(String categoryDescription){
            this.categoryDescription = categoryDescription;
            return this;
        }

        /*public Builder setproduct(List<Product> product){
            this.product = product;
            return this;
        }*/

        public Builder copy(Category category){
            this.categoryID = category.categoryID;
            this.categoryName = category.categoryName;
            this.categoryDescription = category.categoryDescription;
            //this.product = category.product;
            return this;
        }

        public Category build(){
            return new Category(this);
        }
    }
}
