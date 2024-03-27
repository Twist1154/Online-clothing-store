package za.ac.cput.repository;

import za.ac.cput.domain.Order;

import java.util.List;
/*
 *CustomerRepo :java
 * Author: Rethabile Ntsekhe
 * Student num: 22045540
 * Date: 27 March 2024
 */
public interface ICustomerRepo extends IRepository<Order, String>{
        List<Order> getall();

}
