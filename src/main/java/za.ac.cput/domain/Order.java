package za.ac.cput.domain;

/*
 *Order: java
 *Order:Model Class
 * Author: Rethabile Ntsekhe (220455430)
 * Date: 24 March 2024
 */

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Order {
    private String  orderID;
    private String customerID;
    private String  orderItemID;
    private String  addressID;
    private LocalDateTime orderDate;
    private List<Order> orderItems;
    private double totalPrice;
    private String status;

    public Order() {
    }

    public Order(Builder builder) {
        this.orderID = builder.orderID;
        this.customerID = builder.customerID;
        this.orderItemID = builder.orderItemID;
        this.addressID = builder.addressID;
        this.orderDate = builder.orderDate;
        this.orderItems = builder.orderItems;
        this.totalPrice = builder.totalPrice;
        this.status = builder.status;
    }

    public String getOrderID() {
        return orderID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getOrderItemID() {
        return orderItemID;
    }

    public String getAddressID() {
        return addressID;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public List<Order> getOrderItems() {
        return orderItems;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Order{")
                .append(", orderID: '").append(orderID).append('\'')
                .append(", customerID: '").append(customerID).append('\'')
                .append(", orderItemID: '").append(orderItemID).append('\'')
                .append(", addressID: '").append(addressID).append('\'')
                .append(", orderDate: ").append(orderDate)
                .append(", orderItems: ").append(orderItems)
                .append(", totalPrice: ").append(totalPrice)
                .append(", status: '").append(status).append('\'')
                .append('}');
        return stringBuilder.toString();
    }




    public static class Builder{
        private String  orderID;
        private String customerID;
        private String  orderItemID;
        private String  addressID;
        private LocalDateTime orderDate;
        private List<Order> orderItems;
        private double totalPrice;
        private String status;

        public Builder setOrderID(String orderID) {
            this.orderID = orderID;
            return this;
        }

        public Builder setCustomerID(String customerID) {
            this.customerID = customerID;
            return this;
        }

        public Builder setOrderItemID(String orderItemID) {
            this.orderItemID = orderItemID;
            return this;
        }

        public Builder setAddressID(String addressID) {
            this.addressID = addressID;
            return this;
        }

        public Builder setOrderDate(LocalDateTime orderDate) {
            this.orderDate = orderDate.now();
            return this;
        }

        public Builder setOrderItems(List<Order> orderItems) {
            this.orderItems = orderItems;
            return this;
        }

        public Builder setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }
        /*
         *so this method below takes the elements into the builder nested class
         * and creates a copy
         */
        public Order.Builder copy(Order order) {
            this.orderID = orderID;
            this.customerID = customerID;
            this.orderItemID = orderItemID;
            this.addressID = addressID;
            this.orderDate = orderDate;
            this.orderItems = orderItems;
            this.totalPrice = totalPrice;
            this.status = status;
            return this;
        }
        public Order build(){
            Order order = new Order(this);
            return order;
        }

    }
}
