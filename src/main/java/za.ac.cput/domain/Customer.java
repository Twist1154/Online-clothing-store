package za.ac.cput.domain;

/*
 * CustomerFactory: java
 * CustomerFactory: Model Class
 * Author: Rethabile Ntsekhe (220455430)
 * Date: 17 May 2024
 */

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Customer {
    @Id
    private String customerId;
    private String privelages;
    private String userID;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;

    public Customer() {}

    private Customer(Builder builder) {
        this.customerId = builder.customerId;
        this.privelages = builder.privelages;
        this.userID = builder.userID;
        this.orders = builder.orders;
    }

    // Getters and Setters

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPrivelages() {
        return privelages;
    }

    public void setPrivelages(String privelages) {
        this.privelages = privelages;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        if (customerId != null ? !customerId.equals(customer.customerId) : customer.customerId != null) return false;
        if (privelages != null ? !privelages.equals(customer.privelages) : customer.privelages != null) return false;
        return userID != null ? userID.equals(customer.userID) : customer.userID == null;
    }

    @Override
    public int hashCode() {
        int result = customerId != null ? customerId.hashCode() : 0;
        result = 31 * result + (privelages != null ? privelages.hashCode() : 0);
        result = 31 * result + (userID != null ? userID.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", privelages='" + privelages + '\'' +
                ", userID='" + userID + '\'' +
                ", orders=" + orders +
                '}';
    }

    public static class Builder {
        private String customerId;
        private String privelages;
        private String userID;
        private List<Order> orders;

        public Builder setCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder setPrivelages(String privelages) {
            this.privelages = privelages;
            return this;
        }

        public Builder setUserID(String userID) {
            this.userID = userID;
            return this;
        }

        public Builder setOrders(List<Order> orders) {
            this.orders = orders;
            return this;
        }

        public Builder copy(Customer customer) {
            this.customerId = customer.customerId;
            this.privelages = customer.privelages;
            this.userID = customer.userID;
            this.orders = customer.orders;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}
