package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CustomerFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static za.ac.cput.factory.CustomerFactory.createCustomer;

@SpringBootTest
class CustomerServiceTest {
    @Autowired
    private CustomerService customerService;
    private Customer customer;
    private Customer customer1;

    @BeforeEach
    void setUp() {
        System.out.println("-------------------------------------------------------------------START");
        customer = createCustomer("12345L", "Premium", "124567");

        customer1 = createCustomer("67890L", "basic", "77787");
        assertNotNull(customer);
        assertNotNull(customer1);
        System.out.println(customer);
        System.out.println(customer1);
        System.out.println("-------------------------------------------------------------END");
    }

    @Test
    void create() {
        Customer create = customerService.create(customer);
        assertNotNull(create);
        System.out.println("created customer" + create);

        Customer create1 = customerService.create(customer1);
        assertNotNull(create1);
        System.out.println("created customer 2" + create1);
    }

    @Test
    void read() {
        Customer read = customerService.read(customer.getCustomerId());
        Customer read1 = customerService.read(customer1.getCustomerId());
        assertNotNull(read1);
        System.out.println("read Customer " +read);
        System.out.println("read Customer 1" +read1);
    }

    @Test
    void update() {
        Customer customer2 = CustomerFactory.createCustomer("12345L","basic","7654321");
        Customer updated = customerService.update(customer2);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void getAll() {
        System.out.println("All Customers" + customerService.findAll());
    }
}