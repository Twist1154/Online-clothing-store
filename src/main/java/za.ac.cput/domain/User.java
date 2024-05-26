package za.ac.cput.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class User {
    @Id
    private String userID;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    @OneToOne
    private Address address;
    protected User() {
    }

    private User(Builder builder){
        this.userID = builder.userID;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.password = builder.password;
        this.email = builder.email;
        this.address = builder.address;
    }

    public String getUserID() {
        return userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
    public Address getAddress(){
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userID, user.userID) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(password, user.password) && Objects.equals(email, user.email)&& Objects.equals(address, user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, firstName, lastName, password, email,address);
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
        public Builder setAddress(Address address){
            this.address = address;
            return this;
        }

        public Builder copy(User user){
            this.firstName = user.firstName;
            this.lastName = user.lastName;
            this.password = user.password;
            this.email = user.email;
            this.address = user.address;
            return this;
        }
        public User build(){return new User(this);}
    }
}