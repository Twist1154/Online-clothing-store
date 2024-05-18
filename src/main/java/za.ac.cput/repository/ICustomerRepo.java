package za.ac.cput.repository;

import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Order;

import java.util.List;
import java.util.Objects;

/*
 *CustomerRepo :java
 * Author: Rethabile Ntsekhe
 * Student num: 22045540
 * Date: 17 May 2024
 */
public interface ICustomerRepo extends IRepository<Customer, String> {

    Customer create(Customer customer);

    Customer read(String customerId);

    Customer update(Customer customer);

    boolean delete(String customerId);

    List<Customer> getall();
}
