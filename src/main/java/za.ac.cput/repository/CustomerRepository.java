package za.ac.cput.repository;

import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Customer;

import java.util.List;

/*
 *CustomerRepository :java
 * Author: Rethabile Ntsekhe
 * Student num: 22045540
 * Date: 17 May 2024
 */
@Repository
public interface CustomerRepository extends IRepository<Customer, Long> {
    List<Customer> getall();
}
