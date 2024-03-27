package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartItem;
import za.ac.cput.factory.CartFactory;
import za.ac.cput.factory.CartItemFactory;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CartFactoryTest {
    private ArrayList<CartItem> list = new ArrayList<CartItem>();



    @Test
    void testBuildCart(){
        CartItem cItem = CartItemFactory.buildCart("1202","#1432","000100",14.50);
        list.add(cItem);
        Cart cart = CartFactory.buildCart("#1432","0808",60.0,list);
        assertNotNull(cart);
        System.out.println(cart.toString());
    }

    @Test
    void testBuildCartWithFail(){
        CartItem cItem = CartItemFactory.buildCart("1202","","000100",14.50);
        list.add(cItem);
        Cart cart = CartFactory.buildCart("","0808",60.0,list);
        assertNotNull(cart);
        System.out.println(cart.toString());
    }
}