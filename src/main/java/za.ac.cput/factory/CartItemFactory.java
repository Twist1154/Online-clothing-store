package za.ac.cput.factory;

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartItem;
import za.ac.cput.util.Helper;

import java.util.List;

public class CartItemFactory {
    public static CartItem buildCart(String cartItemID, String cartID,String productID, double price){
        if(Helper.isNullOrEmpty(cartItemID) ||
                Helper.isNullOrEmpty(cartID) ||
                price == 0 || Helper.isNullOrEmpty(productID))
            return null;

        return new CartItem.Builder().setCartItemID(cartItemID)
                .setCartID(cartID)
                .setProductID(productID)
                .setPrice(price)
                .build();
    }
}
