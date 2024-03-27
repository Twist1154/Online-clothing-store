package za.ac.cput.repository.impl;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartItem;
import za.ac.cput.factory.CartFactory;
import za.ac.cput.factory.CartItemFactory;
import za.ac.cput.repository.impl.CartRepositoryImpl;
import za.ac.cput.repository.ICartRepository;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CartRepositoryImplTest {
    private static ICartRepository repository = CartRepositoryImpl.getRepository();

    private ArrayList<CartItem> list = new ArrayList<CartItem>();
    private CartItem cItem = CartItemFactory.buildCart("1202","#1432","000100",14.50);
    private Cart cart = CartFactory.buildCart("#1432","0808",60.0,list);

    @Test
    @Order(1)
    void create(){
        list.add(cItem);
        Cart created = repository.create(cart);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    @Order(2)
    void read(){
        Cart read = repository.read(cart.getCartID());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(3)
    void update(){
        Cart newCart = new Cart.Builder().copy(cart).setcartID("#5522").build();
        Cart update = repository.update(newCart);
        assertNotNull(update);
        System.out.println(update);
    }

    @Test
    @Order(5)
    void delete(){
        assertTrue(repository.delete(cart.getCartID()));
        System.out.println("Success: cart deleted");
    }

    @Test
    @Order(4)
    void getall(){
        System.out.println(repository.getall());
    }
}