package za.ac.cput.repository;

import za.ac.cput.domain.Order;

public interface IOrderRepository {

        Order create(Order order);

        Order read(String orderID);

        boolean update(Order updatedOrder);

        boolean delete(String orderID);


}
