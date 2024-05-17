package za.ac.cput.repository.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.CartItem;
import za.ac.cput.factory.CartItemFactory;
import za.ac.cput.repository.ICartItemRepository;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.class)
class CartItemRepositoryTest {

    @Autowired
    private static ICartItemRepository repository = CartItemRepository.getRepository();
    private CartItem cItem = CartItemFactory.buildCart("1202","#1432","000100",14.50);

    @Test
    @Order(1)
    void create(){
        CartItem created = repository.create(cItem);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    @Order(2)
    void read(){
        CartItem read = repository.read(cItem.getCartItemID());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(3)
    void update(){
        CartItem newCItem = new CartItem.Builder().copy(cItem).setCartItemID("1205").build();
        CartItem update = repository.update(newCItem);
        assertNotNull(update);
        System.out.println(update);
    }

    @Test
    @Order(5)
    void delete(){
        assertTrue(repository.delete(cItem.getCartID()));
        System.out.println("Success: cartItem deleted");
    }

    @Test
    @Order(4)
    void getall(){
        System.out.println(repository.getall());
    }
}