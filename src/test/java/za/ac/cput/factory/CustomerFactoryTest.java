package za.ac.cput.factory;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Customer;
import za.ac.cput.repository.ICustomerRepo;
import za.ac.cput.repository.impl.CustomerRepo;

import static org.junit.jupiter.api.Assertions.*;

class CustomerFactoryTest {

    private static Customer customer;
    private static final ICustomerRepo repository = CustomerRepo.getRepository();

    @Test
    @Order(1)
    void createCustomer() {
        Customer createdCustomer = CustomerFactory.createCustomer("123", "Premium", "user123");
        assertNotNull(createdCustomer);
        assertEquals("123", createdCustomer.getCustomerId());
        assertEquals("Premium", createdCustomer.getPrivelages());
        assertEquals("user123", createdCustomer.getUserID());
        customer = createdCustomer;
    }

    @Test
    @Order(2)
    void read() {
        Customer readCustomer = repository.read(customer.getCustomerId());
        assertNotNull(readCustomer);
        assertEquals(customer, readCustomer);
    }

    @Test
    @Order(3)
    void update() {
        Customer updatedCustomer = new Customer.Builder()
                .copy(customer)
                .setPrivelages("Basic")
                .build();

        Customer updated = repository.update(updatedCustomer);
        assertNotNull(updated);
        assertEquals("Basic", updated.getPrivelages());
    }

    @Test
    @Order(4)
    void delete() {
        boolean deleted = repository.delete(customer.getCustomerId());
        assertTrue(deleted);
        assertNull(repository.read(customer.getCustomerId()));
    }
}
