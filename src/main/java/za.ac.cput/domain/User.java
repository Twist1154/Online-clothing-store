package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class User {
    @Id
    private String userID;
    private String firstName;
    private String lastName;
    private String password;
    private String email;

    @OneToOne
    @JoinColumn(name = "addressID")
    private Address address;

    @OneToOne(mappedBy = "user")
    private Customer customer;

    protected User() {}

    private User(Builder builder) {
        this.userID = builder.userID;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.password = builder.password;
        this.email = builder.email;
        this.address = builder.address;
    }

    // Getters and Setters

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                '}';
    }

    public static class Builder {
        private String userID;
        private String firstName;
        private String lastName;
        private String password;
        private String email;
        private Address address;

        public Builder setUserID(String userID) {
            this.userID = userID;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder copy(User user) {
            this.userID = user.userID;
            this.firstName = user.firstName;
            this.lastName = user.lastName;
            this.password = user.password;
            this.email = user.email;
            this.address = user.address;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
