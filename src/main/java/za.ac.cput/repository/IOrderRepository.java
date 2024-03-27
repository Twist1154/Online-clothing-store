package za.ac.cput.repository;

import za.ac.cput.domain.Order;
import java.util.List;

/*
 *IOrderRepository :java
 *IOrder : Model Class
 * Author: Rethabile Ntsekhe
 * Student num: 22045540
 * Date: 27 March 2024
 */
public interface IOrderRepository extends IRepository<Order, String>{
        List<Order> getall();
//        Order create(Order order);
//
//        Order read(String orderID);
//
//        boolean update(Order updatedOrder);
//
//        boolean delete(String orderID);


}
