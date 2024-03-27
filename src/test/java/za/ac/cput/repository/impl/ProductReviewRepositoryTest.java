/**
 * E-Commerce Web Application for selling clothes
 * ProductReviewRepositoryTest.java
 * Test for the ProductReviewRepository
 * Author: Mthandeni Mbobo - 218223579
 * Date: 25 March 2024
 * */

package za.ac.cput.repository.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.ProductReview;
import za.ac.cput.factory.ProductReviewFactory;
import za.ac.cput.repository.IProductReviewRepository;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductReviewRepositoryTest {
    private static IProductReviewRepository repository = ProductReviewRepository.getRepository();
    private ProductReview productReview = ProductReviewFactory.buildProductReview("1", "2", "3", "Test Review", 5);
    private ProductReview productReview2 = ProductReviewFactory.buildProductReview("Test Review 2", 3);

    @Test
    @Order(1)
    void create() {
        ProductReview created = repository.create(productReview);
        assertNotNull(created);

        ProductReview created2 = repository.create(productReview2);
        assertNotNull(created2);
        System.out.println("\nCreated product review1: " + created);
        System.out.println("Created product review2: " + created2);
    }

    @Test
    @Order(2)
    void read() {
        ProductReview read = repository.read(productReview.getProductReviewID());
        assertNotNull(read);
        System.out.println("\nRead product review: " + read);
    }

    @Test
    @Order(3)
    void update() {
        ProductReview newProductReview = new ProductReview.Builder().copy(productReview).setReview("Updated Review").setRating(4).build();
        ProductReview updated = repository.update(newProductReview);
        assertNotNull(updated);
        System.out.println("\nUpdated product review: " + updated);
    }

    @Test
    @Order(5)
    void delete() {
        assertFalse(repository.delete(productReview.getProductReviewID()));
        System.out.println("\nProduct review deleted successfully");
    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println("\nAll product reviews: ");
        System.out.println(repository.getAll());
    }
}