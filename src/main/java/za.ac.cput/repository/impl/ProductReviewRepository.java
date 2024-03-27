/**
 * E-Commerce Web Application for selling clothes
 * ProductReviewRepository.java
 * This class implements the IProductReviewRepository interface and provides the implementation for the ProductReview entity
 * Author: Mthandeni Mbobo - 218223579
 * Date: 24 March 2024
 * */

package za.ac.cput.repository.impl;

import za.ac.cput.domain.ProductReview;
import za.ac.cput.repository.IProductReviewRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductReviewRepository  implements IProductReviewRepository {
    public static ProductReviewRepository productReviewRepository = null;
    private List<ProductReview> productReviewList;

    private ProductReviewRepository(){
        productReviewList = new ArrayList<ProductReview>();
    }

    public static IProductReviewRepository getRepository(){
        if (productReviewRepository == null){
            productReviewRepository = new ProductReviewRepository();
        }
        return productReviewRepository;
    }

    public ProductReview create(ProductReview productReview){
        boolean success = productReviewList.add(productReview);
        if (success){
            return productReview;
        }
        return null;
    }

    public ProductReview read(String productReviewID){
        for (ProductReview productReview: productReviewList){
            if (productReview.getProductReviewID().equals(productReviewID)){
                return productReview;
            }
            return null;
        }
        return null;
    }

    public ProductReview update(ProductReview productReview){
        String productReviewID = productReview.getProductReviewID();
        ProductReview productReviewOld = read(productReviewID);
        if (productReviewOld == null)
            return null;
        boolean success = delete(productReviewID);
        if (success){
            productReviewList.add(productReview);
            return productReview;
        }
        return null;
    }

    public boolean delete(String productReviewID){
        ProductReview productReviewDelete = read(productReviewID);
        if (productReviewDelete == null)
            return false;
        productReviewList.remove(productReviewDelete);
        return true;
    }

    public List<ProductReview> getAll(){
        return productReviewList;
    }
}
