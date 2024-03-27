/**
 * E-Commerce Web Application for selling clothes
 * CategoryRepositoryTest.java
 * Test for the CategoryRepository
 * Author: Mthandeni Mbobo - 218223579
 * Date: 25 March 2024
 * */

package za.ac.cput.repository.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Category;
import za.ac.cput.domain.Product;
import za.ac.cput.factory.CategoryFactory;
import za.ac.cput.repository.ICategoryRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CategoryRepositoryTest {
    private static ICategoryRepository repository = CategoryRepository.getRepository();
    private static Category category = CategoryFactory.buildCategory("1","Mens","Mens Clothing");
    private static Category category2 = CategoryFactory.buildCategory("Womens","Womens Clothing"); //categoryID is auto-generated

    @Test
    @Order(1)
    void create() {
        Category created = repository.create(category);
        assertNotNull(created);

        Category created2 = repository.create(category2);
        assertNotNull(created2);
        System.out.println("\nCreated category1: " + created);
        System.out.println("Created category2: " + created2);
    }

    @Test
    @Order(2)
    void read() {
        Category read = repository.read(category.getCategoryID());
        assertNotNull(read);
        System.out.println("\nRead category: " + read);
    }

    @Test
    @Order(3)
    void update() {
        Category newCategory = new Category.Builder().copy(category).setCategoryName("Updated Category").setCategoryDescription("Updated Test Description").build();
        Category updated = repository.update(newCategory);
        assertNotNull(updated);
        System.out.println("\nUpdated category: " + updated);
    }

    @Test
    @Order(5)
    void delete() {
        assertFalse(repository.delete(category.getCategoryID()));
        System.out.println("\nCategory deleted successfully");
    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println("\nAll categories: ");
        System.out.println(repository.getAll());
    }
}