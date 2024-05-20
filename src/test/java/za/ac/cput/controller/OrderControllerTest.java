package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Order;
import za.ac.cput.factory.OrderFactory;
import za.ac.cput.service.OrderService;

import java.time.LocalDateTime;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderControllerTest {


    private OrderService orderService;

    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8080/shopping_store_db/order";

    private Order order;
    private Order order1;

    @BeforeEach
    void setUp() {
        order = new Order.Builder()
                .setOrderID("11111113445L")
                .setCustomerID("1001")
                .setAddressID("A100")
                .setOrderDate(LocalDateTime.now())
                .setTotalPrice(150.0)
                .setStatus("Pending")
                .setOrderItemsID("1234")
                .build();
        order1 = OrderFactory.createOrder("11111113445L","1001",LocalDateTime.now(),"1234",150.0,"Pending","A100");
    }

    @Test
    void create() {
        String url = BASE_URL  + "/order/create";
        ResponseEntity<Order> response = restTemplate.postForEntity(url, order, Order.class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(order.getOrderID(), Objects.requireNonNull(response.getBody()).getOrderID());
    }

    @Test
    void read() {
        String createUrl = BASE_URL  + "/order/create";
        restTemplate.postForEntity(createUrl, order, Order.class);

        String url = BASE_URL  + "/order/read/" + order.getOrderID();
        ResponseEntity<Order> response = restTemplate.getForEntity(url, Order.class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(order.getOrderID(), Objects.requireNonNull(response.getBody()).getOrderID());
    }

    @Test
    void update() {
        String createUrl = BASE_URL + "/order/create";
        restTemplate.postForEntity(createUrl, order, Order.class);

        order.setStatus("Updated Status");
        String updateUrl = BASE_URL  + "/order/update";
        ResponseEntity<Order> response = restTemplate.postForEntity(updateUrl, order, Order.class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Updated Status", Objects.requireNonNull(response.getBody()).getStatus());
    }

    @Test
    void getAll() {
        String createUrl = BASE_URL  + "/order/create";
        restTemplate.postForEntity(createUrl, order, Order.class);

        String url = BASE_URL + "/order/getAll";
        ResponseEntity<Order[]> response = restTemplate.getForEntity(url, Order[].class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(1, Objects.requireNonNull(response.getBody()).length);
    }
}
