/**
 * E-Commerce Web Application for selling clothes
 * CategoryRepository.java
 * This class implements the ICategoryRepository interface and provides the implementation for the Category entity
 * Author: Mthandeni Mbobo - 218223579
 * Date: 24 March 2024
 * */

package za.ac.cput.repository.impl;

import za.ac.cput.domain.Category;
import za.ac.cput.repository.ICategoryRepository;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepository implements ICategoryRepository {
    public static CategoryRepository categoryRepository = null;
    private List<Category> categoryList;
    private CategoryRepository(){
        categoryList = new ArrayList<Category>();
    }

    public static ICategoryRepository getRepository(){
        if (categoryRepository == null){
            categoryRepository = new CategoryRepository();
        }
        return categoryRepository;
    }

    public Category create(Category category){
        boolean success = categoryList.add(category);
        if (success){
            return category;
        }
        return null;
    }

    public Category read(String categoryID){
        for (Category category: categoryList){
            if (category.getCategoryID().equals(categoryID)){
                return category;
            }
            return null;
        }
        return null;
    }

    public Category update(Category category){
        String categoryID = category.getCategoryID();
        Category categoryOld = read(categoryID);
        if (categoryOld == null)
            return null;
        boolean success = delete(categoryID);
        if (success){
            categoryList.add(category);
            return category;
        }
        return null;
    }

    public boolean delete(String categoryID){
        Category categoryDelete = read(categoryID);
        if (categoryDelete == null)
            return false;
        return (categoryList.remove(categoryDelete));
    }

    public List<Category> getAll(){
        return categoryList;
    }
}
