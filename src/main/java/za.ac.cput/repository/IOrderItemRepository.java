package za.ac.cput.repository;

import za.ac.cput.domain.OrderItem;

import java.util.List;

/*
 *User:java
 *User: Model Class
 * Author: Luke Duffell
 * Student no: 217061567
 * Date: 27 March 2024
 */

public interface IOrderItemRepository extends IRepository<OrderItem, String>{
    List<OrderItem> getall();
}
