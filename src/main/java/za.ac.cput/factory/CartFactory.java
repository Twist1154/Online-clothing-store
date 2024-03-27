package za.ac.cput.factory;

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartItem;
import za.ac.cput.util.Helper;

import java.util.List;

public class CartFactory {

    public static Cart buildCart(String cartID, String customerID, double totalAmpount, List<CartItem> cartItems){
        if(Helper.isNullOrEmpty(cartID) ||
                Helper.isNullOrEmpty(customerID) ||
                totalAmpount == 0 || Helper.isNullOrEmpty(cartItems.toString()))
            return null;

        return new Cart.Builder().setcartID(cartID)
                .setcustomerID(customerID)
                .settotalAmount(totalAmpount)
                .build();
    }
}
