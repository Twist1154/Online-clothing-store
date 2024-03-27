package za.ac.cput.domain;

import java.util.Objects;

public class CartItem {
    private String cartItemID;
    private String cartID;
    private String productID;
    private double price;

    private CartItem(){};

    private CartItem(Builder buildr){
        this.cartItemID = buildr.cartItemID;
        this.cartID = buildr.cartID;
        this.productID = buildr.productID;
        this.price = buildr.price;
    }
    public String getCartItemID() {
        return cartItemID;
    }

    public String getCartID() {
        return cartID;
    }

    public String getProductID() {
        return productID;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return cartItemID == cartItem.cartItemID && cartID == cartItem.cartID && productID == cartItem.productID && Double.compare(price, cartItem.price) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartItemID, cartID, productID, price);
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "cartItemID=" + cartItemID +
                ", cartID=" + cartID +
                ", productID=" + productID +
                ", price=" + price +
                '}';
    }

    public static class Builder{
        private String cartItemID;
        private String cartID;
        private String productID;
        private double price;

        public CartItem.Builder setCartItemID(String cartItemID){
            this.cartItemID = cartItemID;
            return this;
        }

        public CartItem.Builder setCartID(String cartID){
            this.cartID = cartID;
            return this;
        }

        public CartItem.Builder setProductID(String productID){
            this.productID = productID;
            return this;
        }

        public CartItem.Builder setPrice(double price){
            this.price = price;
            return this;
        }

        public Builder copy(CartItem cartItem) {
            this.cartItemID = cartItem.cartItemID;
            this.cartID = cartItem.cartID;
            this.productID = cartItem.productID;
            this.price = cartItem.price;
            return this;
        }

        public CartItem build(){
            return new CartItem(this);
        }
    }
}
