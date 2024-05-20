package za.ac.cput.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order implements Serializable {
    @Id
    private String orderID;
    private String customerID;
    private String addressID;
    private LocalDateTime orderDate;
    private double totalPrice;
    private String status;
    private String orderItemsID;

    public Order() {}

    public Order(Builder builder) {
        this.orderID = builder.orderID;
        this.customerID = builder.customerID;
        this.addressID = builder.addressID;
        this.orderDate = builder.orderDate;
        this.totalPrice = builder.totalPrice;
        this.status = builder.status;
        this.orderItemsID = builder.orderItemsID;
    }

    public String  getOrderID() {
        return orderID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getAddressID() {
        return addressID;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public String  getOrderItems() {
        return orderItemsID;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;

        if (Double.compare(getTotalPrice(), order.getTotalPrice()) != 0) return false;
        if (getOrderID() != null ? !getOrderID().equals(order.getOrderID()) : order.getOrderID() != null) return false;
        if (getCustomerID() != null ? !getCustomerID().equals(order.getCustomerID()) : order.getCustomerID() != null)
            return false;
        if (getAddressID() != null ? !getAddressID().equals(order.getAddressID()) : order.getAddressID() != null)
            return false;
        if (getOrderDate() != null ? !getOrderDate().equals(order.getOrderDate()) : order.getOrderDate() != null)
            return false;
        if (getStatus() != null ? !getStatus().equals(order.getStatus()) : order.getStatus() != null) return false;
        return Objects.equals(orderItemsID, order.orderItemsID);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getOrderID() != null ? getOrderID().hashCode() : 0;
        result = 31 * result + (getCustomerID() != null ? getCustomerID().hashCode() : 0);
        result = 31 * result + (getAddressID() != null ? getAddressID().hashCode() : 0);
        result = 31 * result + (getOrderDate() != null ? getOrderDate().hashCode() : 0);
        temp = Double.doubleToLongBits(getTotalPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (orderItemsID != null ? orderItemsID.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderID +
                ", Customer ID: " + customerID +
                ", Address ID: " + addressID +
                ", Order Date: " + orderDate +
                ", Total Price: $" + totalPrice +
                ", Status: " + status +
                ", Order Items ID: " + orderItemsID;
    }


    public static class Builder {
        private String  orderID;
        private String customerID;
        private String addressID;
        private LocalDateTime orderDate;
        private double totalPrice;
        private String status;
        private String orderItemsID;


        public Builder setOrderID(String  orderID) {
            this.orderID = orderID;
            return this;
        }

        public Builder setCustomerID(String customerID) {
            this.customerID = customerID;
            return this;
        }

        public Builder setAddressID(String addressID) {
            this.addressID = addressID;
            return this;
        }

        public Builder setOrderDate(LocalDateTime orderDate) {
            this.orderDate = orderDate;
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

        public Builder setOrderItemsID(String orderItemsID) {
            this.orderItemsID = orderItemsID;
            return this;
        }
        public Builder copy(Order order) {
            this.orderID = order.orderID;
            this.customerID = order.customerID;
            this.addressID = order.addressID;
            this.orderDate = order.orderDate;
            this.totalPrice = order.totalPrice;
            this.orderItemsID = order.orderItemsID;
            this.status = order.status;
            return this;
        }
        public Order build() {
            return new Order(this);
        }
    }
}
