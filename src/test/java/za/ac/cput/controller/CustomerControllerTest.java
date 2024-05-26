package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.service.ICustomerService;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerControllerTest {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8080/customers";

    private Customer customer;
    private Customer customer1;

    @BeforeEach
    void setUp() {
        customer = new Customer.Builder()
                .setCustomerId("1001")
                .setPrivileges("Admin")
                .setUserID("1122223")
                .build();
        customer1 = CustomerFactory.buildCustomer("1002", "Jane", "111111");
    }

    @Test
    void create() throws Exception {
        String url = BASE_URL;
        ResponseEntity<Customer> response = restTemplate.postForEntity(url, customer1, Customer.class);

        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(customer1.getCustomerId(), Objects.requireNonNull(response.getBody()).getCustomerId());
    }

    @Test
    void read() {
        String createUrl = BASE_URL;
        restTemplate.postForEntity(createUrl, customer, Customer.class);

        String url = BASE_URL + "/" + customer.getCustomerId();
        ResponseEntity<Customer> response = restTemplate.getForEntity(url, Customer.class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(customer.getCustomerId(), Objects.requireNonNull(response.getBody()).getCustomerId());
    }

    @Test
    void update() {
        String createUrl = BASE_URL;
        restTemplate.postForEntity(createUrl, customer, Customer.class);

        customer.setCustomerId("1002");
        String updateUrl = BASE_URL + "/" + customer.getCustomerId();
        restTemplate.put(updateUrl, customer);

        ResponseEntity<Customer> response = restTemplate.getForEntity(updateUrl, Customer.class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Updated Doe", response.getBody().getCustomerId());
    }

    @Test
    void getAllCustomers() {
        String createUrl = BASE_URL;
        restTemplate.postForEntity(createUrl, customer, Customer.class);

        String url = BASE_URL;
        ResponseEntity<Customer[]> response = restTemplate.getForEntity(url, Customer[].class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(1, Objects.requireNonNull(response.getBody()).length);
    }

    @Test
    void delete() {
        String createUrl = BASE_URL;
        restTemplate.postForEntity(createUrl, customer, Customer.class);

        String url = BASE_URL + "/" + customer.getCustomerId();
        restTemplate.delete(url);

        ResponseEntity<Customer> response = restTemplate.getForEntity(url, Customer.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
