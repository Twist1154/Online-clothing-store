/**
 * E-Commerce Web Application for selling clothes
 * ProductReviewFactory.java
 * This class uses the Factory Pattern to create an instance of the ProductReview entity
 * Author: Mthandeni Mbobo - 218223579
 * Date: 23 March 2024
 * */

package za.ac.cput.factory;

import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.ProductReview;
import za.ac.cput.util.Helper;

public class ProductReviewFactory {
    public static ProductReview buildProductReview(String productReviewID, String productID, String customerID, String review, int rating){
        if (Helper.isNullOrEmpty(productReviewID) || Helper.isNullOrEmpty(productID) || Helper.isNullOrEmpty(customerID) || Helper.isNullOrEmpty(review) || Helper.isNullOrEmpty(String.valueOf(rating)))
            return null;

        return new ProductReview.Builder()
                .setProductReviewID(productReviewID)
                .setProductID(productID)
                .setCustomerID(customerID)
                .setReview(review)
                .setRating(rating)
                .build();
    }

    public static ProductReview buildProductReview(String review, int rating){
        if (Helper.isNullOrEmpty(review) || Helper.isNullOrEmpty(String.valueOf(rating)))
            return null;

        String productReviewID = Helper.generateId();
        String productID = Helper.generateId();
        String customerID = Helper.generateId();

        return new ProductReview.Builder()
                .setProductReviewID(Helper.generateId())
                .setProductID(Helper.generateId())
                .setCustomerID(Helper.generateId())
                .setReview(review)
                .setRating(rating)
                .build();
    }
}
