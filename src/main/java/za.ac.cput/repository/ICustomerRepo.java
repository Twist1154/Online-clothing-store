package za.ac.cput.repository;

import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Order;

import java.util.List;
import java.util.Objects;

/*
 *CustomerRepo :java
 * Author: Rethabile Ntsekhe
 * Student num: 22045540
 * Date: 27 March 2024
 */
public interface ICustomerRepo extends IRepository<Order, String> {


    Customer create(Customer customer);

    Customer read(Customer customer);

    Customer update(Customer customer);

    Customer Delete(String  customer);

    boolean delete(Customer customer);

    List<Customer> getall();

}
