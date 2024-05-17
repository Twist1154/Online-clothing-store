/**
 * E-Commerce Web Application for selling clothes
 * CategoryFactory.java
 * This class uses the Factory Pattern to create an instance of the Category entity
 * Author: Mthandeni Mbobo - 218223579
 * Date: 23 March 2024
 * */

package za.ac.cput.factory;

import za.ac.cput.domain.Category;
import za.ac.cput.domain.Product;
import za.ac.cput.util.Helper;

import java.util.List;

public class CategoryFactory {
    public static Category buildCategory(String categoryID, String categoryName){
        if (Helper.isNullOrEmpty(categoryID) || Helper.isNullOrEmpty(categoryName))
            return null;

        return new Category.Builder()
                .setCategoryID(categoryID)
                .setCategoryName(categoryName)
                .build();
    }

    public static Category buildCategory(String categoryName){
        if (Helper.isNullOrEmpty(categoryName))
            return null;

        String categoryID = Helper.generateId();

        return new Category.Builder()
                .setCategoryID(Helper.generateId())
                .setCategoryName(categoryName)
                .build();
    }
}
