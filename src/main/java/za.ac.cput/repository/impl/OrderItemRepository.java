package za.ac.cput.repository.impl;

import za.ac.cput.domain.Customer;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.repository.IOrderItemRepository;

import java.util.ArrayList;
import java.util.List;

/*
 *User:java
 *User: Model Class
 * Author: Luke Duffell
 * Student no: 217061567
 * Date: 27 March 2024
 */

public class OrderItemRepository implements IOrderItemRepository {
    private static IOrderItemRepository repository = null;
    private List<OrderItem> orderItemList;

    private OrderItemRepository() {
        orderItemList = new ArrayList<OrderItem>();
    }

    public static IOrderItemRepository getRepository(){
        if (repository == null){
            repository = new OrderItemRepository();
        }
        return repository;
    }


    @Override
    public OrderItem create(OrderItem orderItem) {
        boolean success = orderItemList.add(orderItem);
        if (success){
            return orderItem;
        }
        return null;
    }

    @Override
    public Customer read(String s) {
        for (OrderItem o : orderItemList){
            if (o.getOrderItemId().equals(s))
                return o;
        }
        return null;
    }

    @Override
    public OrderItem update(OrderItem orderItem) {
        String id = orderItem.getOrderItemId();
        OrderItem orderItemOld = read(id);
        if (orderItemOld == null)
            return null;
        boolean success = delete(id);
        if (success){
            if (orderItemList.add(orderItem))
                return orderItem;
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        OrderItem orderItemToDelete = read(s);
        if (orderItemToDelete == null)
            return false;
        return (orderItemList.remove(orderItemToDelete));
    }

    @Override
    public List<OrderItem> getall() {
        return orderItemList;
    }
}
