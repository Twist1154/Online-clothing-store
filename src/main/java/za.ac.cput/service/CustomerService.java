package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Customer;
import za.ac.cput.repository.CustomerRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    /**
     * @param customer
     * @return customer object
     */
    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer read(String customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    /**
     * @param customer
     * @return updated customer Obj
     */
    @Override
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    /**
     * @return
     */
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }


    @Override
    public List<Customer> findByPrivileges(String privileges) {
        return customerRepository.findByPrivileges(privileges);
    }

    @Override
    public List<Customer> findByUserID(String userID) {
        return customerRepository.findByUserID(userID);
    }

    @Override
    public List<Customer> findCustomersWithOrders() {
        return customerRepository.findCustomersWithOrders();
    }

    @Override
    public List<Customer> findCustomersByOrderStatus(String status) {
        return customerRepository.findCustomersByOrderStatus(status);
    }

    @Override
    public List<Customer> findCustomersByOrderDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return customerRepository.findCustomersByOrderDateRange(startDate, endDate);
    }

    @Override
    public List<Customer> findCustomersByOrderTotalPrice(double price) {
        return customerRepository.findCustomersByOrderTotalPrice(price);
    }
}
