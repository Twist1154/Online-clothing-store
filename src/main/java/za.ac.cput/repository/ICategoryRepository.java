/**
 * E-Commerce Web Application for selling clothes
 * ICategoryRepository.java
 * This class provides the interface for the Category entity
 * Author: Mthandeni Mbobo - 218223579
 * Date: 22 March 2024
 * */

package za.ac.cput.repository;

import za.ac.cput.domain.Category;

import java.util.List;

public interface ICategoryRepository extends IRepository<Category, String>{
    List<Category> getAll();
}
