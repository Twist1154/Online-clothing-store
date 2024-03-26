package za.ac.cput.domain;

/*
 *User:java
 *User: Model Class
 * Author: Luke Duffell
 * Student no: 217061567
 * Date: 27 March 2024
 */

public class OrderItem {
    private String orderItemId;
    private int quantity;
    private double price;

    public OrderItem(){
    }

    private OrderItem(Builder builder){
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

    public double getPrice() {
        return price;
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
