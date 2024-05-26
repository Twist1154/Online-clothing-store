package za.ac.cput.service;

import za.ac.cput.domain.Customer;

import java.time.LocalDateTime;
import java.util.List;

public interface ICustomerService extends IService<Customer, String> {


    List<Customer> findByPrivileges(String privileges);

    List<Customer> findByUserID(String userID);

    List<Customer> findCustomersWithOrders();

    List<Customer> findCustomersByOrderStatus(String status);

    List<Customer> findCustomersByOrderDateRange(LocalDateTime startDate, LocalDateTime endDate);

    List<Customer> findCustomersByOrderTotalPrice(double price);
}
