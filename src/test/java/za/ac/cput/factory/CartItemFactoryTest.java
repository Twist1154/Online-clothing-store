package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartItem;
import za.ac.cput.factory.CartFactory;
import za.ac.cput.factory.CartItemFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;


public class CartItemFactoryTest {
    @Test
    void testBuildCart(){
        CartItem cItem = CartItemFactory.buildCart("1202","#1432","000100",14.50);
        assertNotNull(cItem);
        System.out.println(cItem.toString());
    }

    @Test
    void testBuildCartWithFail(){
        CartItem cItem = CartItemFactory.buildCart("1202","","000100",14.50);
        assertNotNull(cItem);
        System.out.println(cItem.toString());
    }
}