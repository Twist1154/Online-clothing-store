package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Order;
import za.ac.cput.factory.OrderFactory;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    private Order order;

    @BeforeEach
    public void setUp() {
        // Creating test data
        String orderID = "11111113445L";
        String customerID = "1001";
        LocalDateTime orderDate = LocalDateTime.now();
        String orderItemsID = "1234";
        double totalPrice = 150.0;
        String status = "Pending";
        String addressID = "A100";

        order = OrderFactory.createOrder(orderID, customerID, orderDate, orderItemsID, totalPrice, status, addressID);
    }

    @Test
    @org.junit.jupiter.api.Order(1)
    void create() {
        System.out.println("Creat--------------------------------------------------");
        Order createdOrder = orderService.create(order);
        assertNotNull(createdOrder);
        assertEquals(order.getOrderID(), createdOrder.getOrderID());
        System.out.println(createdOrder);
        System.out.println("Created--------------------------------------------------");
    }

    @Test
    @org.junit.jupiter.api.Order(2)
    void read() {
        System.out.println("read-----------------------------------------------");
        Order order1 = orderService.read(order.getOrderID());
        assertNotNull(order1);
        System.out.println(order1);
        System.out.println("read-----------------------------------------------");
    }

    @Test
    @org.junit.jupiter.api.Order(3)
    void update() {
        System.out.println("------------------------------------update");
        Order up_Order = new Order.Builder().copy(order).setStatus("Completed").build();
        Order completedOrder = orderService.update(up_Order);
        assertEquals(up_Order.getStatus(), completedOrder.getStatus());
        System.out.println("Order Status Updated: " + completedOrder);
        System.out.println("----------------------------------------------updated");
    }

    @Test
    @org.junit.jupiter.api.Order(4)
    void getAll() {
        System.out.println("All orders: " + orderService.getAll());
    }
}
