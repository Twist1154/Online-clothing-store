/**
 * E-Commerce Web Application for selling clothes
 * ProductReviewFactoryTest.java
 * Test for the ProductReviewFactory
 * Author: Mthandeni Mbobo - 218223579
 * Date: 25 March 2024
 * */

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.ProductReview;

import static org.junit.jupiter.api.Assertions.*;

class ProductReviewFactoryTest {

    /*@Test
    void buildProductReview() {
        ProductReview productReview = ProductReviewFactory.buildProductReview("21212sdfsdf","dfsdfsdf", "sfsdfsdf","Great product", 8);
        assertNotNull(productReview);
        System.out.println(productReview);
    }

    @Test
    void testBuildProductReview() {
        ProductReview productReview = ProductReviewFactory.buildProductReview("Great product", 10);
        assertNotNull(productReview);
        System.out.println(productReview);
    }*/

    String productReviewID = "1";
    String productID = "1";
    String customerID = "1";
    String review = "Great product";
    int rating = 8;

    @Test
    //This test will pass, productReviewID, productID, customerID, review and rating are not null
    void buildProductReview() {
        ProductReview productReview = ProductReviewFactory.buildProductReview(productReviewID, productID, customerID, review, rating);
        assertNotNull(productReview);
        System.out.println(productReview);
    }

    @Test
    void testBuildProductReview() {
        ProductReview productReview = ProductReviewFactory.buildProductReview(review, rating); //productReviewID is auto-generated
        assertNotNull(productReview);
        System.out.println(productReview);
    }
}