/**
 * E-Commerce Web Application for selling clothes
 * CategoryFactoryTest.java
 * Test for the CategoryFactory
 * Author: Mthandeni Mbobo - 218223579
 * Date: 25 March 2024
 * */

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Category;
import za.ac.cput.domain.Product;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategoryFactoryTest {

    /*@Test
    void buildCategory() {
        Category category = CategoryFactory.buildCategory("1","Mens","Mens Clothing",null);
        assertNotNull(category);
        System.out.println(category);
    }

    @Test
    void testBuildCategory() {
        Category category = CategoryFactory.buildCategory("Mens","Mens Clothing",null);
        assertNotNull(category);
        System.out.println(category);
    }*/

    String categoryID = "1";
    String categoryName = "Men";
    String categoryDescription = "Clothing for men";

    @Test
    //This test will pass, categeoryID, categoryName, categoryDescription and products are not null
    void buildCategory() {
        Category category = CategoryFactory.buildCategory(categoryID, categoryName, categoryDescription);
        assertNotNull(category);
        System.out.println(category);
    }

    @Test
    //This test will pass, categoryName, categoryDescription, products are not null
    void testBuildCategory() {
        Category category = CategoryFactory.buildCategory(categoryName, categoryDescription); //categoryID is auto-generated
        assertNotNull(category);
        System.out.println(category);
    }
}