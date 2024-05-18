package za.ac.cput.factory;

/*
 *Customer:java
 *Customer: Model Class
 * Author: Rethabile Ntsekhe (220455430)
 * Date: 25 / March/2024
 */

import za.ac.cput.domain.Customer;
import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

public class CustomerFactory {

    public static Customer createCustomer(String customerId, String privileges, User user) {
        // Validate the inputs using Helper class
        if (Helper.isNullOrEmpty(customerId) ||
                Helper.isNullOrEmpty(privileges) ||
                Helper.isNullOrEmpty(user.getUserID())) {
            return null;
        }

        return new Customer.Builder()
                .setCustomerId(customerId)
                .setPrivileges(privileges)
                .setUser(user)
                .build();
    }
}
