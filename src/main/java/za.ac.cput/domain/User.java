package za.ac.cput.domain;

public class User {
    private String userID;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String addressID;

    private User(Builder builder) {
        this.userID = builder.userID;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.password = builder.password;
        this.email = builder.email;
        this.addressID = builder.addressID;
    }

    public String getUserID() { return userID;}

    public String getFirstName() {return firstName;}

    public String getLastName() {return lastName;}

    public String getPassword() {return password;}

    public String getEmail() {return email; }

    public String getAddressID() {return addressID;}

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", addressID='" + addressID + '\'' +
                '}';
    }
    public static class Builder{
        private String userID;
        private String firstName;
        private String lastName;
        private String password;
        private String email;
        private String addressID;

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

        public Builder setAddressID(String addressID) {
            this.addressID = addressID;
            return this;
        }

        public Builder copy(User user){
            this.userID = user.userID;
            this.firstName = user.firstName;
            this.lastName = user.lastName;
            this.password = user.password;
            this.email = user.email;
            this.addressID = user.addressID;
            return this;
        }

        public User build(){return new User(this);}
    }


}
