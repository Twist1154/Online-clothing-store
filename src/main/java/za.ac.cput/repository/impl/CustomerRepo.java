package za.ac.cput.repository.impl;

import za.ac.cput.domain.Customer;
import za.ac.cput.repository.ICustomerRepo;

import java.util.ArrayList;
import java.util.List;

/*
 *CustomerRepo :java
 * Author: Rethabile Ntsekhe
 * Student num: 22045540
 * Date: 27 March 2024
 */

public class CustomerRepo implements ICustomerRepo {
    private static ICustomerRepo repository = null;
    private List<Customer> customerList;

    private CustomerRepo() {
        customerList = new ArrayList<>();
    }

    public static ICustomerRepo getRepository() {
        if (repository == null) {
            repository = new CustomerRepo();
        }
        return repository;
    }

    @Override
    public Customer create(Customer customer) {
        boolean success = customerList.add(customer);
        if (success) {
            return customer;
        }
        return null;
    }

    @Override
    public Customer read(String customerId) {
        for (Customer customer : customerList) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public Customer update(Customer customer) {
        String id = customer.getCustomerId();
        Customer customerOld = read(id);
        if (customerOld == null) {
            return null;
        }
        boolean success = delete(id);
        if (success) {
            customerList.add(customer);
            return customer;
        }
        return null;
    }

    @Override
    public boolean delete(String customerId) {
        Customer toDelete = read(customerId);
        if (toDelete == null) {
            return false;
        }
        return customerList.remove(toDelete);
    }

    @Override
    public List<Customer> getall() {
        return customerList;
    }
}
