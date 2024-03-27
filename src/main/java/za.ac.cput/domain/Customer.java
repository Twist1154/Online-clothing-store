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

    public void setCustomerId(String  customerId) {
        this.customerId = customerId;
    }
    public String getPrivelages() {
        return privelages;
    }

    public void setPrivelages(String privelages){
        this.privelages = privelages;
    }

    public String  getUserID() {
        return userID;
    }

    public void setUserID(String  userID) {
        this.userID = userID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;

        if (getCustomerId() != null ? !getCustomerId().equals(customer.getCustomerId()) : customer.getCustomerId() != null)
            return false;
        if (getPrivelages() != null ? !getPrivelages().equals(customer.getPrivelages()) : customer.getPrivelages() != null)
            return false;
        return getUserID() != null ? getUserID().equals(customer.getUserID()) : customer.getUserID() == null;
    }

    @Override
    public int hashCode() {
        int result = getCustomerId() != null ? getCustomerId().hashCode() : 0;
        result = 31 * result + (getPrivelages() != null ? getPrivelages().hashCode() : 0);
        result = 31 * result + (getUserID() != null ? getUserID().hashCode() : 0);
        return result;
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
