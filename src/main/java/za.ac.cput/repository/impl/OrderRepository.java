package za.ac.cput.repository.impl;

import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Order;
import za.ac.cput.repository.IOrderRepository;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository implements IOrderRepository {

    private static IOrderRepository repository = null;
    private static List<Order> orderList;

    private OrderRepository() {
        orderList = new ArrayList<Order>();
    }

    public static IOrderRepository getRepository() {
        if (repository == null) {
            repository = new OrderRepository();
        }
        return  repository;
    }

    @Override
    public Order create(Order order) {
        boolean created = orderList.add(order);
        if (created) {
            return order;
        }
        return null;
    }


    public Customer read(String  orderID) {
        for (Order order : orderList)
            if (order.getOrderID() == orderID) {
                return order;
            }
        return null;
    }

    @Override
    public Order update(Order updatedOrder) {
        for (int i = 0; i < orderList.size(); i++) {
            Order order = orderList.get(i);
            if (order.getOrderID() == updatedOrder.getOrderID()) {
                orderList.set(i, updatedOrder);
                return updatedOrder;
            }
        }
        return updatedOrder;
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

    @Override
    public List<Order> getall() {
        return orderList;
    }
}

