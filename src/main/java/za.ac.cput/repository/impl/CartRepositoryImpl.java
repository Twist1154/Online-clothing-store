package za.ac.cput.repository.impl;

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartItem;
import za.ac.cput.domain.Product;
import za.ac.cput.repository.ICartRepository;

import java.util.ArrayList;
import java.util.List;

public class CartRepositoryImpl implements ICartRepository {

    private static ICartRepository repository = null;
    private List<Cart> cartList;

    private CartRepositoryImpl(){cartList = new ArrayList<Cart>();}

    public static ICartRepository getRepository(){
        if(repository == null){
            repository = new CartRepositoryImpl();
        }
        return repository;
    }
    public Cart create(Cart cart) {
        boolean success = cartList.add(cart);
        if (success){
            return cart;
        }
        return null;
    }

    public Cart read(String s) {
        for(Cart c: cartList){
            if(c.getCartID().equals(s))
                return c;
        }
        return null;
    }

    public Cart update(Cart cart) {
        String s = cart.getCartID();
        Cart cart1 = getRepository().read(s);
        if(cart1 == null)
            return null;
        boolean  success = delete(s);
        if(success){
            if(cartList.add(cart))
                return cart;
        }
        return null;
    }

    public boolean delete(String s) {
        Cart cartDelete = read(s);
        if(cartDelete == null)
            return false;
        return (cartList.remove(cartDelete));
    }

    public List<Cart> getall() {
        return cartList;
    }

}
