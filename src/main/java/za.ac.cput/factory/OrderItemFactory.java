package za.ac.cput.factory;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.util.Helper;

/*
 *User:java
 *User: Model Class
 * Author: Luke Duffell
 * Student no: 217061567
 * Date: 27 March 2024
 */

public class OrderItemFactory {
    public static OrderItem buildOrderItem(String orderItemId, int quantity, double price){
        if (Helper.isNullOrEmpty(orderItemId) || Helper.isNullOrEmpty(String.valueOf(quantity)) || Helper.isNullOrEmpty(String.valueOf(price)))
            return null;

        return new OrderItem.Builder().setOrderItemId(orderItemId)
                .setQuantity(quantity)
                .setPrice(price)
                .build();
    }
}
