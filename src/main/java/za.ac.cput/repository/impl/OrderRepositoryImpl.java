package za.ac.cput.repository.impl;

import za.ac.cput.domain.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl implements IOrderRepository {

    private static OrderRepositoryImpl repository = null;
    private static List<Order> orderList; // Corrected variable name

    private OrderRepositoryImpl() {
        orderList = new ArrayList<>();
    }

    public static OrderRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new OrderRepositoryImpl();
        }
        return repository;
    }

    @Override
    public Order create(Order order) {
        boolean created = orderList.add(order);
        if (created) {
            return order;
        }
        return null;
    }



    @Override
    public Order read(String  orderID) {
        for (Order order : orderList)
            if (order.getOrderID() == orderID) {
                return order;
            }
        return null;
    }

    @Override
    public boolean update(Order updatedOrder) {
        for (int i = 0; i < orderList.size(); i++) {
            Order order = orderList.get(i);
            if (order.getOrderID() == updatedOrder.getOrderID()) {
                orderList.set(i, updatedOrder);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(String  orderID) {
        for (Order order : orderList) {
            if (order.getOrderID() == orderID) {
                return orderList.remove(order);
            }
        }
        return false;
    }
}

