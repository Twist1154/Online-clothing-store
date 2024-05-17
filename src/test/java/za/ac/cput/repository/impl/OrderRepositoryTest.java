package za.ac.cput.repository.impl;

//import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Order;
import za.ac.cput.repository.IOrderRepository;


import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepositoryTest {
    private static final IOrderRepository repository = OrderRepository.getRepository();



    @Test
    void create() {
        Order order = new Order.Builder()
                .setOrderID("1")
                .setCustomerID("customer1")
                .setOrderItemID("item1")
                .setAddressID("address1")
                .setOrderDate(LocalDateTime.now())
                .setOrderItemId(new ArrayList<>())
                .setTotalPrice(100.00)
                .setStatus("pending")
                .build();

        Order createdOrder = repository.create(order);
        assertNotNull(createdOrder);
        assertEquals(order.getOrderID(), createdOrder.getOrderID());
    }


    @Test
    void read() {
        Order order = new Order.Builder()
                .setOrderID("1")
                .setCustomerID("customer1")
                .setOrderItemID("item1")
                .setAddressID("address1")
                .setOrderDate(LocalDateTime.now())
                .setOrderItemId(new ArrayList<>())
                .setTotalPrice(100.00)
                .setStatus("pending")
                .build();

       repository.create(order);

        Order retrievedOrder = repository.read("1");
        assertNotNull(retrievedOrder);
        assertEquals(order.getOrderID(), retrievedOrder.getOrderID());
    }

    @Test
    void update() {
        Order order = new Order.Builder()
                .setOrderID("1")
                .setCustomerID("customer1")
                .setOrderItemID("item1")
                .setAddressID("address1")
                .setOrderDate(LocalDateTime.now())
                .setOrderItemId(new ArrayList<>())
                .setTotalPrice(100.00)
                .setStatus("pending")
                .build();

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
        Order order = new Order.Builder()
                .setOrderID("1")
                .setCustomerID("customer1")
                .setOrderItemID("item1")
                .setAddressID("address1")
                .setOrderDate(LocalDateTime.now())
                .setOrderItemId(new ArrayList<>())
                .setTotalPrice(100.00)
                .setStatus("pending")
                .build();

        repository.create(order);

        boolean deleted = repository.delete("1");
        assertTrue(deleted);

        Order deletedOrder = repository.read("1");
        assertNull(deletedOrder);
    }
}