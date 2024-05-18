package za.ac.cput.factory;


import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Customer;
import za.ac.cput.repository.ICustomerRepo;

import static org.junit.jupiter.api.Assertions.*;

class CustomerFactoryTest {

    private static Customer customer;

    @Test
    void createCustomer() {
        Customer createdCustomer = CustomerFactory.createCustomer("123", "Premium", "user123");
        assertNotNull(createdCustomer);
        assertEquals("123", createdCustomer.getCustomerId());
        assertEquals("Premium", createdCustomer.getPrivelages());
        assertEquals("user123", createdCustomer.getUserID());
        customer = createdCustomer;
        
    }

}
