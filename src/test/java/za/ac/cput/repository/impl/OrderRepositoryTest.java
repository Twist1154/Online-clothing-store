package za.ac.cput.repository.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Order;
import za.ac.cput.repository.IOrderRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepositoryTest {

    private IOrderRepository repository;

    @BeforeEach
    void setUp() {
        repository = OrderRepository.getRepository();
    }

    @Test
    void create() {
        Order order = buildOrder("1", "customer1", "item1", "address1", 100.00, "pending");
        Order createdOrder = repository.create(order);
        assertNotNull(createdOrder);
        assertEquals(order.getOrderID(), createdOrder.getOrderID());
    }

    @Test
    void read() {
        Order order = buildOrder("1", "customer1", "item1", "address1", 100.00, "pending");
        repository.create(order);

        Order retrievedOrder = repository.read("1");
        assertNotNull(retrievedOrder);
        assertEquals(order.getOrderID(), retrievedOrder.getOrderID());
    }

    @Test
    void update() {
        Order order = buildOrder("1", "customer1", "item1", "address1", 100.00, "pending");
        repository.create(order);

        order.setStatus("shipped");

        Order updated = repository.update(order);
        assertNotNull(updated);

        Order updatedOrder = repository.read("1");
        assertNotNull(updatedOrder);
        assertEquals("shipped", updatedOrder.getStatus());
    }

    @Test
    void delete() {
        Order order = buildOrder("1", "customer1", "item1", "address1", 100.00, "pending");
        repository.create(order);

        boolean deleted = repository.delete("1");
        assertTrue(deleted);

        Order deletedOrder = repository.read("1");
        assertNull(deletedOrder);
    }

    private Order buildOrder(String orderID, String customerID, String orderItemId,
                             String addressID, double totalPrice, String status) {
        return new Order.Builder()
                .setOrderID(orderID)
                .setCustomerID(customerID)
                .setOrderID(orderItemId)
                .setAddressID(addressID)
                .setOrderDate(LocalDateTime.now())
                .setOrderItems(new ArrayList<>())
                .setTotalPrice(totalPrice)
                .setStatus(status)
                .build();
    }
}
