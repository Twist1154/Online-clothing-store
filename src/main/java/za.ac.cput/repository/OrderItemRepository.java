package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.OrderItem;

import java.util.List;

/*
 *IOrderItemRepository:java
 *OrderItem: Repository Class
 * Author: Luke Duffell
 * Student no: 217061567
 * Date: 17 May 2024
 */
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, String>{
}
