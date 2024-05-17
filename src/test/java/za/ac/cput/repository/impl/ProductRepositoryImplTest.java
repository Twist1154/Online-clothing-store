package za.ac.cput.repository.impl;
/*
 *Product:java
 *Product: ProductImageRepositoryTest Class
 * Author: Zachariah Matsimella
 * Date: 26 March 2024
 */


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Product;
import za.ac.cput.repository.IProductRepository;
import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryImplTest {
    private static IProductRepository repository;
    private Product product;
    @BeforeEach
    void setUp(){
        repository = ProductRepositoryImpl.getRepository();
        product = new Product.Builder()
                .setCategoryID("1")
                .setName("Hoodie")
                .setDescription("White medium Hoodie.")
                .setPrice(300)
                .setStock(50)
                .setReviewID("1")
                .setImageID("1")
                .build();
    }

    @Test
    @Order(1)
    void create(){
        Product created = repository.create(product);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    @Order(2)
    void read(){
        Product read = repository.read(product.getProductID());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(3)
    void update(){
        Product product1 = new Product.Builder()
                .setCategoryID("1")
                .setName("Hoodie")
                .setDescription("White medium Hoodie. Cozy.")
                .setPrice(250)
                .setStock(25)
                .setReviewID("1")
                .setImageID("1")
                .build();
        Product updated = repository.update(product1);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Order(5)
    void delete(){
        assertTrue(repository.delete(product.getProductID()));
        System.out.println("Product: "+ product+" was deleted");
    }

    @Test
    @Order(4)
    void getall(){
        System.out.println(repository.getAll());
    }
}
