package za.ac.cput.repository.impl;
/**
 * E-Commerce Web Application for selling clothes
 * CartRepositoryTest.java
 * Test for the CartRepository
 * Author: Kinzonzi Genereux Mukoko - 221477934
 * Date: 16 May 2024
 * */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartItem;
import za.ac.cput.factory.CartFactory;
import za.ac.cput.factory.CartItemFactory;
import za.ac.cput.repository.ICartRepository;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
@SpringBootTest
@TestMethodOrder(MethodOrderer.class)
class CartRepositoryTest {
    @Autowired
    private static ICartRepository repository = CartRepository.getRepository();

    private ArrayList<CartItem> list = new ArrayList<CartItem>();
    private CartItem cItem = CartItemFactory.buildCart("1202","#1432","000100",14.50);
    private Cart cart = CartFactory.buildCart("#1432","0808",60.0,list);

    @Test
    @Order(1)
    void setUp(){
        list.add(cItem);
        assertNotNull(list);
        System.out.println(list);
    }

    @Test
    @Order(2)
    void create(){
        Cart created = repository.create(cart);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    @Order(3)
    void read(){
        Cart read = repository.read(cart.getCartID());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(4)
    void update(){
        Cart newCart = new Cart.Builder().copy(cart).setcartID("#5522").build();
        Cart update = repository.update(newCart);
        assertNotNull(update);
        System.out.println(update);
    }

    @Test
    @Order(6)
    void delete(){
        assertTrue(repository.delete(cart.getCartID()));
        System.out.println("Success: cart deleted");
    }

    @Test
    @Order(5)
    void getall(){
        System.out.println(repository.getall());
    }
}