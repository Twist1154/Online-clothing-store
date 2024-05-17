package za.ac.cput.factory;

/*
 * Customer: java
 * Customer: Model Class
 * Author: Rethabile Ntsekhe (220455430)
 * Date: 17 MAy 2024
 */

import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Order;
import za.ac.cput.util.Helper;

import java.util.List;

public class CustomerFactory {

    public static Customer createCustomer(String customerId, String privelages, String userID, List<Order> orders) {

        if (Helper.isNullOrEmpty(customerId) ||
                Helper.isNullOrEmpty(privelages) ||
                Helper.isNullOrEmpty(userID)) {
            return null;
        }

        return new Customer.Builder()
                .setCustomerId(customerId)
                .setPrivelages(privelages)
                .setUserID(userID)
                .setOrders(orders)
                .build();
    }

    public static Customer createCustomer(String customerId, String privelages, String userID) {
        return createCustomer(customerId, privelages, userID, null);
    }
}
