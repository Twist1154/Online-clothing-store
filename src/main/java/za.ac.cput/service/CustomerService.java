package za.ac.cput.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Customer;
import za.ac.cput.repository.CustomerRepository;
import za.ac.cput.repository.OrderRepository;

import java.util.List;

/*
 * Order: java
 * Order: Model Class
 * Author: Rethabile Ntsekhe (220455430)
 * Date: 18 May 2024
 */
@Service
public class CustomerService implements ICustomerService{
    private final CustomerRepository repository;


    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer create(Customer customer) {
        return repository.create(customer);
    }

    @Override
    public Customer  read(Long  id) {
        return repository.read(id);
    }

    @Override
    public Customer update(Customer customer) {
        return repository.update(customer);
    }

    @Override
    public List<Customer> getAll() {
        return repository.getall();
    }
}
