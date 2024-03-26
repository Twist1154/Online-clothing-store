package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.OrderItem;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemFactoryTest {

    @Test
    void buildOrderItem() {
        OrderItem orderItem = OrderItemFactory.buildOrderItem("PC9775", 5, 9.99);

        assertNotNull(orderItem);
        System.out.println(orderItem);
    }
}