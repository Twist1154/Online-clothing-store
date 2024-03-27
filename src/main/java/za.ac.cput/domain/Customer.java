package za.ac.cput.domain;

/*
 *CustomerFactory:java
 *CustomerFactory: Model Class
 * Author: Rethabile Ntsekhe (220455430)
 * Date: 25 / March/2024
 */

public class Customer {
    private String  customerId;
    private String privelages;
    private String  userID;

    public Customer() {

    }

    private Customer(Builder builder) {
        this.customerId = builder.customerId;
        this.privelages = builder.privelages;
        this.userID = builder.userID;
    }

    public String  getCustomerId() {
        return customerId;
    }

    public String getPrivelages() {
        return privelages;
    }

    public String  getUserID() {
        return userID;
    }

    @Override
    public String toString() {
        return ", CustomerFactory: " +
                ", ID: " + customerId +
                ", Privelages: '" + privelages + '\'' +
                ", User ID: " + userID +
                '}';
    }

    public static class Builder{
        private String  customerId;
        private String privelages;
        private String  userID;

        public Builder setCustomerId(String  customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder setPrivileges(String privelages) {
            this.privelages = privelages;
            return this;
        }

        public Builder setUserID(String  userID) {
            this.userID = userID;
            return this;
        }

        /*
         *so this method below takes the elements into the builder nested class
         * and creates a copy
         */
        public Customer.Builder copy(Customer customer) {
            this.customerId = customer.customerId;
            this.privelages = customer.privelages;
            this.userID = customer.userID;
            return this;
        }
        public Customer build(){
            Customer customer = new Customer(this);
            return customer;
        }
    }
}
