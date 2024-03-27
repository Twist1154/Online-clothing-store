package za.ac.cput.factory;

/*
 *Customer:java
 *Customer: Model Class
 * Author: Rethabile Ntsekhe (220455430)
 * Date: 25 / March/2024
 */

import za.ac.cput.domain.Customer;
import za.ac.cput.util.Helper;


public class CustomerFactory {
    private String customerId;
    private String privelages;
    private String userID;

    public static Customer createCustomer(String customerId, String privelages, String userID) {

        if (Helper.isNullOrEmpty(String.valueOf(customerId)) ||
                Helper.isNullOrEmpty(privelages) ||
                Helper.isNullOrEmpty(userID)) {
            return null;
        }
        return new Customer.Builder()
                .setCustomerId(customerId)
                .setPrivileges(privelages)
                .setUserID(userID)
                .build();

    }
}
