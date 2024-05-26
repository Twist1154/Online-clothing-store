package za.ac.cput.factory;

/*
 * CustomerFactory.java
 * Customer Factory Class
 * Author: Rethabile Ntsekhe (220455430)
 * Date: 17 May 2024
 */

import za.ac.cput.domain.Customer;
import za.ac.cput.util.Helper;

public class CustomerFactory {

    /**
     * Creates a Customer instance.
     *
     * @param customerId the ID of the customer
     * @param privileges the privileges of the customer
     * @param userID the user ID associated with the customer
     * @return a new Customer instance if parameters are valid, otherwise null
     */
    public static Customer buildCustomer(String customerId, String privileges, String userID) {

        // Validate the input parameters using the Helper class
        if (Helper.isNullOrEmpty(customerId) ||
                Helper.isNullOrEmpty(privileges) ||
                Helper.isNullOrEmpty(userID)) {
            return null; // Return null if any parameter is invalid
        }

        // Build and return the Customer instance
        return new Customer.Builder()
                .setCustomerId(customerId)
                .setPrivileges(privileges)
                .setUserID(userID)
                .build();
    }
}
