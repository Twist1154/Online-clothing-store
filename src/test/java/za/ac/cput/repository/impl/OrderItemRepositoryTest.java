package za.ac.cput.repository.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.factory.OrderItemFactory;
import za.ac.cput.repository.IOrderItemRepository;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderItemRepositoryTest {
    private static IOrderItemRepository repository = OrderItemRepository.getRepository();
    private OrderItem orderItem = OrderItemFactory.buildOrderItem("PC5211", 5, 9.99);

    @Test
    @Order(1)
    void create(){
        OrderItem created = repository.create(orderItem);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    @Order(2)
    void read(){
        OrderItem read = repository.read(orderItem.getOrderItemId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(3)
    void update(){
        OrderItem newOrderItem = new OrderItem.Builder().copy(orderItem).setQuantity(12).setPrice(5.49).build();
        OrderItem updated = repository.update(newOrderItem);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Order(5)
    void delete(){
        assertTrue(repository.delete(orderItem.getOrderItemId()));
        System.out.println("Success: order item deleted");
    }

    @Test
    @Order(4)
    void getall(){
        System.out.println(repository.getall());
    }
}