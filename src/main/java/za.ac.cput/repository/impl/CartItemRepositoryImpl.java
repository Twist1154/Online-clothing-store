package za.ac.cput.repository.impl;

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartItem;
import za.ac.cput.repository.ICartItemRepository;
import za.ac.cput.repository.ICartRepository;

import java.util.ArrayList;
import java.util.List;

public class CartItemRepositoryImpl implements ICartItemRepository {
    private static ICartItemRepository repository = null;
    private List<CartItem> cartItemList;

    private CartItemRepositoryImpl(){cartItemList = new ArrayList<CartItem>();}

    public static ICartItemRepository getRepository(){
        if(repository == null){
            repository = new CartItemRepositoryImpl();
        }
        return repository;
    }
    public CartItem create(CartItem cartItem) {
        boolean success = cartItemList.add(cartItem);
        if (success){
            return cartItem;
        }
        return null;
    }

    public CartItem read(String s) {
        for(CartItem c: cartItemList){
            if(c.getCartItemID().equals(s))
                return c;
        }
        return null;
    }

    @Override
    public CartItem update(CartItem cartItem) {
        String s = cartItem.getCartItemID();
        CartItem cartItem1 = getRepository().read(s);
        if(cartItem1 == null)
            return null;
        boolean  success = delete(s);
        if(success){
            if(cartItemList.add(cartItem))
                return cartItem;
        }
        return null;
    }

    public boolean delete(String s) {
        CartItem cartItemDelete = read(s);
        if(cartItemDelete == null)
            return false;
        return (cartItemList.remove(cartItemDelete));
    }

    public List<CartItem> getall() {
        return cartItemList;
    }


}
