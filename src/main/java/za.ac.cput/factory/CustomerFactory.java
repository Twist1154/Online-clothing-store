package za.ac.cput.factory;

/*
 *Customer:java
 *Customer: Model Class
 * Author: Rethabile Ntsekhe (220455430)
 * Date: 25 / March/2024
 */

public class CustomerFactory {
    private String  customerId;
    private String privelages;
    private String  userID;

    public CustomerFactory() {

    }

    private CustomerFactory(Builder builder) {
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
    public String toString() {
        return "Customer: " +
                "ID: " + customerId +
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

        public Builder setPrivelages(String privelages) {
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
        public CustomerFactory.Builder copy(CustomerFactory customer) {
            this.customerId = customer.customerId;
            this.privelages = customer.privelages;
            this.userID = customer.userID;
            return this;
        }
        public CustomerFactory build(){
            CustomerFactory customer = new CustomerFactory(this);
            return customer;
        }
    }
}
