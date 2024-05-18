package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.User;

public class CustomerFactoryTest {

    @Test
    void createCustomer() {
        // My User object to pass to the CustomerFactory
        User user = new User.Builder()
                .setUserID("user123")
                .setFirstName("Rethabile")
                .setLastName("Ntsekhe")
                .setPassword("pass")
                .setEmail("220455430@mycput.ac.za")
                .setAddressID("needs to me connected to the the Address entity")
                .build();

        // Customer object using the CustomerFactory that will be added to before my user details appear
        Customer createdCustomer = CustomerFactory.createCustomer("123", "Premium", user);
        System.out.println(createdCustomer);
        // Validate that the Customer object is not null and has correct attributes
        assertNotNull(createdCustomer);
        assertEquals("123", createdCustomer.getCustomerId());
        assertEquals("Premium", createdCustomer.getPrivileges());
        assertEquals("user123", createdCustomer.getUserID().getUserID());
    }
}
