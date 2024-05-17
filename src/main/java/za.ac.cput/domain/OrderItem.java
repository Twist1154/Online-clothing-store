package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

/*
 *OrderItem:java
 *OrderItem: Model Class
 * Author: Luke Duffell
 * Student no: 217061567
 * Date: 17 May 2024
 */

@Entity
public class OrderItem {
    @Id
    private String orderItemId;
    private int quantity;
    private double price;

    protected OrderItem(){}

    public OrderItem(Builder builder){
        this.orderItemId = builder.orderItemId;
        this.quantity = builder.quantity;
        this.price = builder.price;
    }

    public String getOrderItemId() {
        return orderItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {return price;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return quantity == orderItem.quantity && Double.compare(price, orderItem.price) == 0 && Objects.equals(orderItemId, orderItem.orderItemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderItemId, quantity, price);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "OrderItem{" +
                "orderItemId=" + orderItemId + '\'' +
                ", quantity=" + quantity + '\'' +
                ", price=" + price + '\'' +
                '}';
    }

    public static class Builder{
        private String orderItemId;
        private int quantity;
        private double price;

        public Builder setOrderItemId(String orderItemId){
            this.orderItemId = orderItemId;
            return this;
        }

        public Builder setQuantity(int quantity){
            this.quantity = quantity;
            return this;
        }

        public Builder setPrice(double price){
            this.price = price;
            return this;
        }

        public Builder copy(OrderItem orderItem){
            this.orderItemId = orderItem.orderItemId;
            this.quantity = orderItem.quantity;
            this.price = orderItem.price;
            return this;
        }

        public OrderItem build(){
            return new OrderItem(this);
        }
    }
}
